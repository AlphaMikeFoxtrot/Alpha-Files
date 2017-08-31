package com.example.anonymous.caffeinetrackeriii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import static android.widget.ArrayAdapter.createFromResource;

public class AddCup extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner beverage_spinner;
    Spinner coffeeSpinner;
    EditText quantity;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cup);

        beverage_spinner = (Spinner) findViewById(R.id.beverage_spinner);
        coffeeSpinner = (Spinner) findViewById(R.id.teaCoffee);
        quantity = (EditText) findViewById(R.id.quantity);
        submit = (Button) findViewById(R.id.submit);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.beverage, android.R.layout.simple_spinner_item);

        beverage_spinner.setAdapter(adapter);
        beverage_spinner.setOnItemSelectedListener(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beverage_spinner.getSelectedItem().equals("Type Of Beverage") && coffeeSpinner.getSelectedItem().equals("None")){

                    Toast.makeText(getApplicationContext(), "PLEASE MAKE SURE ALL THE REQUIRED FIELDS ARE FILLED!!!", Toast.LENGTH_SHORT).show();

                } else {

                    String packetType = coffeeSpinner.getSelectedItem().toString();
                    String packetQuantity = quantity.getText().toString();
                    Intent toShowAdded = new Intent(getApplicationContext(), Added.class);
                    toShowAdded.putExtra("PACKET", packetType);
                    toShowAdded.putExtra("QUANTITY", packetQuantity);
                    startActivity(toShowAdded);

                }
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (beverage_spinner.getSelectedItem().equals("Coffee")) {

            ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
                    R.array.coffee, android.R.layout.simple_spinner_item);
            coffeeSpinner.setAdapter(adapter2);

        }

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}

