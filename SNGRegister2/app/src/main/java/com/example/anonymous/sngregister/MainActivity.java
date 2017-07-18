package com.example.anonymous.sngregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.anonymous.sngregister.R.string.addEntry;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declaring class variables for listeners
        Button addEntry = (Button) findViewById(R.id.addEntry);
        Button attendance = (Button) findViewById(R.id.attendance);

        // declaring class intent variables:
        final Intent toAddEntry = new Intent(this, AddEntry.class);

        addEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toAddEntry);
            }
        });
    }


}
