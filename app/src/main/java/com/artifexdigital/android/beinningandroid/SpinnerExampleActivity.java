package com.artifexdigital.android.beinningandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerExampleActivity extends AppCompatActivity {

    private Spinner mySpinner;
    private TextView mySelection;
    private static final String[] myListItems = "Business Learn more about hiring developers or posting ads with us".split(" ");
    private static int curId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_example);
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

        mySelection = (TextView) findViewById(R.id.mySelection);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, myListItems);

        mySpinner = (Spinner) findViewById(R.id.mySpinner);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TODO when display rotates position becomes 1 even if selected item is not null
                mySelection.setText(myListItems[position]);
                curId = position;
                mySpinner.setSelection(curId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        if (curId >= 0) {
            mySpinner.setSelection(curId);
            mySelection.setText(String.valueOf(mySpinner.getSelectedItemPosition()));

        }
    }

}
