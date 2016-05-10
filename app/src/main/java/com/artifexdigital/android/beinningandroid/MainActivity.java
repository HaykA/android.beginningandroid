package com.artifexdigital.android.beinningandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initTextViewObjects((TableLayout) findViewById(R.id.buttonContainer));
    }

    private static List<TableRow> getTableRows(TableLayout layout){
        List<TableRow> rows = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < layout.getChildCount(); i++) {
            if (layout.getChildAt(i) instanceof TableRow) {
                rows.add((TableRow)layout.getChildAt(i));
            }
        }
        return rows;
    }

    private static void initTextViewObjects(TableLayout layout) {
        int j = 1;
        for(TableRow row : getTableRows(layout)) {
            for (int i = 0; i < row.getChildCount(); i++) {
                if (row.getChildAt(i) instanceof TextView && !(row.getChildAt(i) instanceof Button)) {
                    TextView textView = (TextView) row.getChildAt(i);
                    textView.setText(String.valueOf(j++));
                    textView.setWidth(54);
                    textView.setGravity(Gravity.RIGHT);
                    textView.setPadding(0, 0, 12, 0);
                }
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startIncrementButton(View view) {
        startActivity(new Intent(this, IncrementButtonActivity.class));
    }

    public void startImageView(View view) {
        startActivity(new Intent(this, ImageViewActivity.class));
    }

    public void startEditTextExample(View view) {
        startActivity(new Intent(this, EditTextActivity.class));
    }

    public void startCheckBoxExample(View view) {
        startActivity(new Intent(this, CheckBoxActivity.class));
    }

    public void startSwitchExample(View view) {
        startActivity(new Intent(this, SwitchExampleActivity.class));
    }

    public void startRadioButtonGroupExample(View view) {
        startActivity(new Intent(this, RadioButtonGroupActivity.class));
    }

    public void startClocksExample(View view) {
        startActivity(new Intent(this, ClocksExampleActivity.class));
    }

    public void startSeekBarExample(View view) {
        startActivity(new Intent(this, SeekBarExampleActivity.class));
    }

    public void startRelativeLayoutExample(View view) {
        startActivity(new Intent(this, RelativeLayoutExampleActivity.class));
    }

    public void startRelativeOverlapExample(View view) {
        startActivity(new Intent(this, RelativeOverlapExampleActivity.class));
    }

    public void startLinearLayoutExample(View view) {
        startActivity(new Intent(this, LinearLayoutExampleActivity.class));
    }

    public void startTableLayoutExample(View view) {
        startActivity(new Intent(this, TableLayoutExampleActivity.class));
    }

    public void startGridViewExample(View view) {
        startActivity(new Intent(this, GridViewExampleActivity.class));
    }

    public void startSpinnerExample(View view) {
        startActivity(new Intent(this, SpinnerExampleActivity.class));
    }

    public void startAutocompleteTextViewExample(View view) {
        startActivity(new Intent(this, AutocompleteTextViewExampleActivity.class));
    }

    public void startIMEExample1(View view) {
        startActivity(new Intent(this, IMEExample1Activity.class));
    }

    public void startOptionMenuExample(View view) {
        startActivity(new Intent(this, OptionMenuExampleActivity.class));
    }

    public void startMenuXMLExample(View view) {
        startActivity(new Intent(this, MenuXMLExampleActivity.class));
    }

    public void startPopupExample(View view) {
        startActivity(new Intent(this, PopupExamplesActivity.class));
    }
}
