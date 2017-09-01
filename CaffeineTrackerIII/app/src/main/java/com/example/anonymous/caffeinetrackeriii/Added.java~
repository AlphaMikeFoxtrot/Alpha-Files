package com.example.anonymous.caffeinetrackeriii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Added extends AppCompatActivity {

    TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added);

        summary = (TextView) findViewById(R.id.summary);
        Intent intent = getIntent();

        String packetType = intent.getStringExtra("PAKCET");
        String packetQuantity = intent.getStringExtra("QUANTITY");

        int mPacketQuantity = Integer.parseInt(packetQuantity);

        double coffeeAmt = 0;

        if(packetType == "Bru(RS.2)"){

            coffeeAmt += 1.9*(60/100);

        } else if(packetType == "Bru(RS.5)"){

            coffeeAmt += 5.3*(60/100);

        } else {

            coffeeAmt += 8.9/(60/100);

        }

        double caffeineAmt = coffeeAmt * mPacketQuantity;

        String sum = "AMOUNT OF CAFFEINE CONSUMED = " + caffeineAmt;
        summary.setText(sum);

    }
}
