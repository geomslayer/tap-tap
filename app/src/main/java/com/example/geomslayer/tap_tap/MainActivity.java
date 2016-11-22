package com.example.geomslayer.tap_tap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int countTaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTaps = 10;
        setCountTaps(countTaps);
    }

    public void onStart(View view) {
        Intent startGame = new Intent(this, PlaygroundActivity.class);
        startGame.putExtra("countTaps", Integer.toString(countTaps));
        startActivity(startGame);
    }

    public void onClickCountTaps(View view) {
        CountTaps count = new CountTaps();
        getFragmentManager();
        count.show(getSupportFragmentManager(), "23");
    }

    public void setCountTaps(int curCount) {
        countTaps = curCount;
        ((TextView) findViewById(R.id.count_taps)).setText(getString(R.string.count_taps) + ": " + countTaps);
    }

    public int getCountTaps() {
        return countTaps;
    }
}
