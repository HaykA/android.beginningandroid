package com.artifexdigital.android.beinningandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ClocksExampleActivity extends AppCompatActivity {

    AnalogClock analog;
    DigitalClock digital;
    RadioButton radio1;
    RadioButton radio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clocks_example);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group_clocks);
        analog = (AnalogClock) findViewById(R.id.myAnalogClock);
        digital = (DigitalClock) findViewById(R.id.myDigitalClock);
        digital.setTextSize(60F);

        analog.setVisibility(View.INVISIBLE);
        digital.setVisibility(View.INVISIBLE);

        radio1 = (RadioButton) findViewById(R.id.radio_analog);
        radio2 = (RadioButton) findViewById(R.id.radio_digital);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radio1.getId()) {
                    analog.setVisibility(View.VISIBLE);
                    digital.setVisibility(View.INVISIBLE);
                } else if (checkedId == radio2.getId()) {
                    analog.setVisibility(View.INVISIBLE);
                    digital.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
