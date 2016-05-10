package com.artifexdigital.android.beinningandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class IncrementButtonActivity extends AppCompatActivity implements View.OnClickListener {
    Button myButton;
    Integer myInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_increment_button);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(2);
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
        myButton = (Button) findViewById(R.id.myButton);

        myButton.setOnClickListener(this);
        myInt = 0;
        updateClickCounter();

    }


    @Override
    public void onClick(View v) {
        updateClickCounter();
    }

    private void updateClickCounter() {
        myInt++;
        Button myButton = (Button) findViewById(R.id.myButton);
        myButton.setText(myInt.toString());
    }
}
