package com.example.anonymous.sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.anonymous.sqllite.R.id.amount;

public class MainActivity extends AppCompatActivity {

    EditText inputAmount;
    Button add;
    Button delete;
    TextView summary;
    DeltaBravoHandler deltaBravoHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputAmount = (EditText) findViewById(amount);
        add = (Button) findViewById(R.id.add);
        delete = (Button) findViewById(R.id.delete);
        summary = (TextView) findViewById(R.id.summary);
        deltaBravoHandler = new DeltaBravoHandler(this, null, null, 1);

    }

    public void addAmountToDatabase(View view){

        Amount amount = new Amount(Integer.parseInt(inputAmount.getText().toString()));
        deltaBravoHandler.addToDB(amount);
        printSummary();

    }

    public void deleteAmountFromDatabase(View view){

        deltaBravoHandler.deleteFromDB(Integer.parseInt(inputAmount.getText().toString()));
        printSummary();

    }

    public void printSummary(){

        String content = deltaBravoHandler.databaseToString();
        summary.setText(content);
        inputAmount.setHint("");

    }
}
