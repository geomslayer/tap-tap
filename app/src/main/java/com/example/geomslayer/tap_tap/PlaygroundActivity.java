package com.example.geomslayer.tap_tap;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class PlaygroundActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    private int needTaps = 10;
    private final int delay = 25;
    private int countTaps = 0;
    private TextView timer;
    private long startTime;
    private Stopwatch stopwatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);

        Log.v("qwe", getIntent().getStringExtra("countTaps"));
        needTaps = Integer.parseInt(getIntent().getStringExtra("countTaps"));
        timer = (TextView) findViewById(R.id.timer);
        updateTimer(0);
    }

    protected long getDiff() {
        return System.currentTimeMillis() - startTime;
    }

    protected void updateTimer(long time) {
        long mills = time % 1000;
        long sec = time / 1000 % 60;
        long min = time / 60000 % 60;
        timer.setText(String.format("%02d:%02d:%03d", min, sec, mills));
    }

    public void onTap(View view) {
        if (countTaps == 0) {
            startTime = System.currentTimeMillis();
            stopwatch = new Stopwatch();
            stopwatch.execute();
        }
        ++countTaps;
        if (countTaps == needTaps) {
            stopwatch.cancel(true);
        }
    }

    class Stopwatch extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                while (true) {
                    publishProgress();
                    TimeUnit.MILLISECONDS.sleep(delay);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... voids) {
            super.onProgressUpdate(voids);
            updateTimer(getDiff());
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            updateTimer(getDiff());
        }

    }

}

