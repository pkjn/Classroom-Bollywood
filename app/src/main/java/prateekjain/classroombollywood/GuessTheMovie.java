package prateekjain.classroombollywood;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import prateekjain.classroombollywood.CounterPack.CircularCounter;

public class GuessTheMovie extends AppCompatActivity implements View.OnClickListener {
    Button reset, enter;
    TextView movie1, bollywood, charused;
    EditText enterchar;
    static String mname;
    String s1;
    char j[];
    int fm = 0;
    char m[] = new char[26];
    int w = 0;
    String s2;
    char g[] = new char[9];
    long timer_time = 120000;
    private CircularCounter meter;
    private String[] colors;
    MyCountDownTimer myCountDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_movie);
        movie1 = (TextView) findViewById(R.id.movie1);
        bollywood = (TextView) findViewById(R.id.bollywood);
        charused = (TextView) findViewById(R.id.charused);
        //reset = (Button) findViewById(R.id.reset);
        //reset.setOnClickListener(this);
        enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(this);
        enterchar = (EditText) findViewById(R.id.enterchar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        try {
            assert actionBar != null;
            actionBar.setDisplayShowTitleEnabled(true);
        } catch (Exception ignored) {
        }
        Bundle extras = getIntent().getExtras();
        mname = extras.getString("mname");
        timer_time = extras.getLong("timer_time");
        char[] c = mname.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
            } else if (c[i] == ' ') {
                c[i] = '/';
            } else {
                c[i] = '_';
            }
        }
        j = new char[c.length];
        int l = 0;
        char[] cj;
        cj = new char[2 * c.length];
        for (char che : c) {
            cj[l] = che;
            l++;
            cj[l] = ' ';
            l++;
        }
        s2 = new String(cj);
        movie1.setText(s2);
        startTimer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.reset:
                reset();
                break;*/
            case R.id.enter:
                if (movie1.getText().equals("")) {
                    new AlertDialog.Builder(this)
                            .setTitle("Message For You")
                            .setMessage("Enter Movie First")
                            .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).show();
                    enterchar.setText("");
                    return;

                }
                if (enterchar.getText().toString().equals("")) {
                    new AlertDialog.Builder(this)
                            .setTitle("Message For You")
                            .setMessage("Please Enter Aplhabet")
                            .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).show();
                    enterchar.setText("");
                    return;
                }
                char[] c1 = enterchar.getText().toString().toLowerCase().toCharArray();
                char alpha = c1[0];
                if (alpha == 'a' || alpha == 'e' || alpha == 'i' || alpha == 'o' || alpha == 'u') {
                    Toast.makeText(getApplicationContext(), "Vowels already filled", Toast.LENGTH_LONG).show();
                    enterchar.setText("");
                    return;
                }
                for (int i = 0; i < m.length; i++) {
                    if (m[i] == alpha) {
                        Toast.makeText(getApplicationContext(), "Already Used", Toast.LENGTH_LONG).show();
                        enterchar.setText("");
                        return;
                    }
                }
                m[w] = alpha;
                w++;
                char[] c11 = mname.toCharArray();
                int k = 0;
                for (int i = 0; i < c11.length; i++) {
                    if (c11[i] == j[i]) {
                    } else if (c11[i] == 'a' || c11[i] == 'e' || c11[i] == 'i' || c11[i] == 'o' || c11[i] == 'u') {
                    } else if (c11[i] == ' ') {
                        c11[i] = '/';
                    } else if (c11[i] == alpha) {
                        c11[i] = alpha;
                        k++;
                        j[i] = c11[i];
                    } else {
                        c11[i] = '_';
                    }
                }
                if (k == 0) {
                    if (fm == 0) {
                        bollywood.setText("B");
                        g[fm] = alpha;
                        String b = new String(g);
                        charused.setText(b);
                    } else if (fm == 1) {
                        bollywood.setText("Bo");
                        g[fm] = alpha;
                        String b = new String(g);
                        charused.setText(b);
                    } else if (fm == 2) {
                        bollywood.setText("Bol");
                        g[fm] = alpha;
                        String b = new String(g);
                        charused.setText(b);
                    } else if (fm == 3) {
                        bollywood.setText("Boll");
                        g[fm] = alpha;
                        String b = new String(g);
                        charused.setText(b);
                    } else if (fm == 4) {
                        bollywood.setText("Bolly");
                        g[fm] = alpha;
                        String b = new String(g);
                        charused.setText(b);
                    } else if (fm == 5) {
                        bollywood.setText("Bollyw");
                        g[fm] = alpha;
                        String b = new String(g);
                        charused.setText(b);
                    } else if (fm == 6) {
                        bollywood.setText("Bollywo");
                        g[fm] = alpha;
                        String b = new String(g);
                        charused.setText(b);
                    } else if (fm == 7) {
                        bollywood.setText("Bollywoo");
                        g[fm] = alpha;
                        String b = new String(g);
                        charused.setText(b);
                    } else if (fm == 8) {
                        bollywood.setText("Bollywood");
                        g[fm] = alpha;
                        String b = new String(g);
                        charused.setText(b);
                    }
                    fm++;
                }
                if (bollywood.getText().toString().equals("Bollywood")) {
                    loose();
                }
                int l1 = 0;
                char[] cj1;
                cj1 = new char[2 * c11.length];
                for (char che : c11) {
                    cj1[l1] = che;
                    l1++;
                    cj1[l1] = ' ';
                    l1++;
                }
                String s21 = new String(cj1);
                enterchar.setText("");
                movie1.setText(s21);
                for (int i = 0; i < c11.length; i++) {
                    if (c11[i] == '_') {
                        return;
                    }
                }
                won();
                break;
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (myCountDownTimer != null) {
            myCountDownTimer.cancel();
            finish();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (myCountDownTimer != null) {
            myCountDownTimer.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myCountDownTimer != null) {
            myCountDownTimer.cancel();
        }
    }

    private void loose() {
        Toast.makeText(getApplicationContext(), "You Loose", Toast.LENGTH_LONG).show();
        reset();
    }

    private void reset() {
        myCountDownTimer.cancel();
        meter.setValues(0, 60, 0);
        new AlertDialog.Builder(this)
                .setTitle("Message For You")
                .setMessage("Movie Name:  " + mname)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();
    }

    private void won() {
        Toast.makeText(getApplicationContext(), "You Won Loosing  " + fm + "  alphabets.", Toast.LENGTH_LONG).show();
        reset();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_guess_the_movie, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.iquit) {
            reset();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startTimer() {
        try {
            if (myCountDownTimer != null) {
                myCountDownTimer.cancel();
            }
            colors = getResources().getStringArray(R.array.colors);
            meter = (CircularCounter) findViewById(R.id.meter);
            meter.setFirstWidth(getResources().getDimension(R.dimen.first))
                    .setFirstColor(Color.parseColor(colors[0]))
                    .setSecondWidth(getResources().getDimension(R.dimen.second))
                    .setSecondColor(Color.parseColor(colors[1]))
                    .setBackgroundColor(Color.parseColor(colors[2]));
            myCountDownTimer = new MyCountDownTimer(timer_time, 1000);
            myCountDownTimer.start();
        } catch (Exception e) {
        }
    }

    public class MyCountDownTimer extends CountDownTimer {
        int minutes, min_interval, show_min = 60;

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            minutes = (int) ((millisInFuture / (1000 * 60)) % 60);
            if (minutes != 0) {
                min_interval = 60 / minutes;
            }
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int seconds = (int) (millisUntilFinished / 1000) % 60;
            if (seconds == 59) {
                show_min -= min_interval;
            }

            try {
                meter.setValues(seconds, show_min, 0);
            } catch (Exception e) {
            }
        }

        @Override
        public void onFinish() {
            meter.setValues(0, 60, 0);
            if (mname != null) {
                loose();
            }
        }
    }
}
