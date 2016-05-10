package com.artifexdigital.android.beinningandroid;

import android.app.ListActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class OptionMenuExampleActivity extends AppCompatActivity {

    public static final int MENU_RESET = Menu.FIRST + 1;
    public static final int MENU_UPPER = Menu.FIRST + 2;
    public static final int MENU_REMOVE = Menu.FIRST + 3;

    private static final String[] myListItems = "Business Learn more about hiring developers or posting ads with us".split(" ");
    private ArrayList<String> words = null;

    private ListView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu_example);
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

        menu = (ListView) findViewById(android.R.id.list);
        setupAdapter();
        registerForContextMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MENU_RESET, Menu.NONE, "Reset");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(Menu.NONE, MENU_UPPER, Menu.NONE, "Upper Case");
        menu.add(Menu.NONE, MENU_REMOVE, Menu.NONE, "Remove Word");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case MENU_RESET:
                setupAdapter();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo
                = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) menu.getAdapter();

        switch(item.getItemId()) {
            case MENU_UPPER:
                String word = words.get(menuInfo.position);
                word = word.toUpperCase();
                adapter.remove(words.get(menuInfo.position));
                adapter.insert(word, menuInfo.position);
                return true;

            case MENU_REMOVE:
                adapter.remove(words.get(menuInfo.position));
                return true;
        }
        return super.onContextItemSelected(item);
    }

    private void setupAdapter() {
        words = new ArrayList<>();

        for (String someItem : myListItems) {
            words.add(someItem);
        }

        menu.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words));
    }
}
