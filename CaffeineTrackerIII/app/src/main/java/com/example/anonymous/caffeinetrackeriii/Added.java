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

        String packetType = intent.getStringExtra("PACKET");
        String packetQuantity = intent.getStringExtra("QUANTITY");

        int mPacketQuantity = Integer.parseInt(packetQuantity.toString());

        double coffeeAmt = 0;
        String sum = " ";

        if(packetType.toString() == "Bru(RS.2)"){

            coffeeAmt += (1.9*60/100) * mPacketQuantity;
            sum += "AMOUNT OF CAFFEINE CONSUMED = " + coffeeAmt;
            summary.setText(" " + coffeeAmt);

        } else if(packetType.toString() == "Bru(RS.5)"){

            coffeeAmt += (5.3*60/100) * mPacketQuantity;
            sum += "AMOUNT OF CAFFEINE CONSUMED = " + coffeeAmt;
            summary.setText(" " + coffeeAmt);

        } else {

            coffeeAmt += (8.9*60/100) * mPacketQuantity;
            sum += "AMOUNT OF CAFFEINE CONSUMED = " + coffeeAmt;
            summary.setText(" " + coffeeAmt);

        }

    }
}
