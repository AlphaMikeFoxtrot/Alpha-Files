package com.example.anonymous.caffeinetrackeriii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.anonymous.caffeinetrackeriii.R.array.coffee;

public class Added extends AppCompatActivity {

    TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added);

        summary = (TextView) findViewById(R.id.summary);
        Intent intent = getIntent();

        float caffeineAmt = (float) intent.getDoubleExtra("CAFFEINEamt", 0);

        summary.setText(" " + caffeineAmt);


    }
}
