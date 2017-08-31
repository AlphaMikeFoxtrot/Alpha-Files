package com.example.anonymous.caffeinetrackeriii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button toAdd;
    Button toLog;
    Intent i_toAdd;
    Intent i_toLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toAdd = (Button) findViewById(R.id.add);
        toLog = (Button) findViewById(R.id.log);

        i_toAdd = new Intent(this, AddCup.class);

        toAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i_toAdd);
            }
        });
    }
}
