package prateekjain.classroombollywood;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prateek Jain on 01-Sep-15.
 */
public class DurationPicker extends TimePickerDialog {

    private TimePicker timePicker;
    private final OnTimeSetListener callback;

    private int initialMinutes;

    public DurationPicker(Context context, OnTimeSetListener callBack, int minutes, int seconds) {
        super(context, callBack, minutes, seconds, true); // the last argument removes the am/pm spinner
        this.callback = callBack;
        try {


            this.initialMinutes = minutes; // we'll have to set this again after modifying the "hours" spinner
            this.setTitle("Set duration");
        }catch (Exception e){}
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (callback != null && timePicker != null) {
            timePicker.clearFocus();
            callback.onTimeSet(timePicker, timePicker.getCurrentHour(), timePicker.getCurrentMinute());
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            Class<?> classForid = Class.forName("com.android.internal.R$id");
            Field timePickerField = classForid.getField("timePicker");
            this.timePicker = (TimePicker) findViewById(timePickerField.getInt(null));
            Field field = classForid.getField("hour");

            // modify the hours spinner to cover the maximum number of minutes we want to support
            int maxMinutes = 60;
            NumberPicker mHourSpinner = (NumberPicker)timePicker.findViewById(field.getInt(null));
            mHourSpinner.setMinValue(0);
            mHourSpinner.setMaxValue(maxMinutes);
            List<String> displayedValues = new ArrayList<String>();
            for (int i = 0; i <= maxMinutes; i++) {
                displayedValues.add(String.format("%d", i));
            }
            mHourSpinner.setDisplayedValues(displayedValues.toArray(new String[0]));
            mHourSpinner.setValue(initialMinutes); // we can set this again now that we've modified the hours spinner
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}