package com.artifexdigital.android.beinningandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridViewExampleActivity extends AppCompatActivity {

    private TextView mySelection;
    private GridView myGridView;
    private static final String[] myListItems = "Business Learn more about hiring developers or posting ads with us".split(" ");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_example);
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
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cell, myListItems);

        myGridView = (GridView) findViewById(R.id.grid);
        myGridView.setAdapter(adapter);

        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO when display rotates position becomes 1 even if selected item is not null
                mySelection.setText(myListItems[position]);
            }
        });
    }

}
