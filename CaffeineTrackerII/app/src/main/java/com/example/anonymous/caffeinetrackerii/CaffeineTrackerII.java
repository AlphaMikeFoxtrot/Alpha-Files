package com.example.anonymous.caffeinetrackerii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.ArrayAdapter.createFromResource;

public class CaffeineTrackerII extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner beverage_spinner;
    Spinner coffeeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caffeine_tracker_ii);

        beverage_spinner = (Spinner) findViewById(R.id.beverage_spinner);
        coffeeSpinner = (Spinner) findViewById(R.id.teaCoffee);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.beverage, android.R.layout.simple_spinner_item);

        beverage_spinner.setAdapter(adapter);
        beverage_spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (beverage_spinner.getSelectedItem().equals("Coffee")) {
            Toast.makeText(getApplicationContext(), "Coffee",
                    Toast.LENGTH_SHORT).show();

            ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
                    R.array.coffee, android.R.layout.simple_spinner_item);
            coffeeSpinner.setAdapter(adapter2);
        }

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
