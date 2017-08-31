package com.example.anonymous.caffeinetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class aBru extends AppCompatActivity {

    Button toHome;
    Intent i_toHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_bru);

        toHome = (Button) findViewById(R.id.backToHome);
        i_toHome = new Intent(this, MainActivity.class);

        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i_toHome);
            }
        });
    }
}
