package prateekjain.classroombollywood;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button submit;
    EditText movie;
    static String mname;
    long timer_time = 120000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
        movie = (EditText) findViewById(R.id.movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        try {
            assert actionBar != null;
            actionBar.setDisplayShowTitleEnabled(true);
        } catch (Exception ignored) {
        }
    }

    public void onClick(View v) {
        if (movie.getText().toString().isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Message For You")
                    .setMessage("Enter Movie First")
                    .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).show();
            return;
        }
        mname = movie.getText().toString().toLowerCase();
        movie.setText("");
        Intent intent = new Intent(MainActivity.this, GuessTheMovie.class);
        intent.putExtra("mname", mname);
        intent.putExtra("timer_time", timer_time);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.timer) {
            try {
                new DurationPicker(MainActivity.this, new DurationPicker.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timer_time = (hourOfDay * 60 * 1000) + (minute * 1000);
                    }
                }, 2, 0).show();
            } catch (Exception e) {
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}