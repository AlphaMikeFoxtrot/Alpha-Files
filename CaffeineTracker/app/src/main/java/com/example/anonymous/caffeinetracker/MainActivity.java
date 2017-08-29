package com.example.anonymous.caffeinetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button coffee;
    Button tea;

    Intent toCoffee;
    Intent toTea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coffee = (Button) findViewById(R.id.coffee);
        tea = (Button) findViewById(R.id.tea);

        toCoffee = new Intent(this, Coffee.class);
        toTea = new Intent(this, Tea.class);

        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toCoffee);
            }
        });

        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toTea);
            }
        });

    }
}
