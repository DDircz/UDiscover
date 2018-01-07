package com.example.ddircz.sandbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Jaytielle on 4/12/17.
 */

public class FiltersActivity extends AppCompatActivity{
    Button filterButton;
    private SeekBar seekBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        setupActionBar();

        filterButton = (Button)findViewById(R.id.buttonFilter);

        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Filtering Results", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        textView = (TextView) findViewById(R.id.textView1);
        // Initialize the textview with '0'
        textView.setText(seekBar.getProgress() + "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int progress = 0;
                    @Override
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progresValue, boolean fromUser) {
                        progress = progresValue;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // Do something here,
                        //if you want to do anything at the start of
                        // touching the seekbar
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // Display the value in textview
                        textView.setText(progress + "/" + seekBar.getMax());
                    }
                });

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        //this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_drawer_drawer, menu);
        return true;
    }

}
