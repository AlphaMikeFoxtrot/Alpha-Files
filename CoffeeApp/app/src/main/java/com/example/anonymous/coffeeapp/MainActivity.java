package com.example.anonymous.coffeeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.anonymous.coffeeapp.R.id.creamTop;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    // declaring class variable quantity:
    int quantity = 0;

    /*
     *increment is called when "+" button is pressed
     * adds 1 to the quantity variable
     */
    public void increment(View view){

        quantity += 1;
        displayQuantity(quantity);

    }

    /*
     * decrement method is called when "-" is pressed
     * decreases the value of quantity by one
     */
    public void decrement(View view){

        if (quantity > 0){
            quantity -= 1;
        } else {
            quantity = 0;
        }
        displayQuantity(quantity);

    }

//    public void reset(View view){
//
//        quantity = 0;
//        displayQuantity(quantity);
//        TextView temp = (TextView) findViewById(R.id.dollars);
//        temp.setText("$0");
//        CheckBox temp2 = (CheckBox) findViewById(R.id.creamTop);
//        temp2.setChecked(false);
//        CheckBox temp3 = (CheckBox) findViewById(R.id.chocTop);
//        temp3.setChecked(false);
//        EditText inpt = (EditText) findViewById(R.id.name);
//        inpt.setText("");
//
//    }

    /*
     * order method is called when the order button is pressed
     * calls the "displayOrder" method
     */
    public void order(View view){

        int price = quantity *= 5;
        displayOrder(price);

    }

    /*
     * this method is called by "order" method
     * creates and executes the email intent
     * sets the subject and body of the email
     */
    private void displayOrder(int number){

        String body;

        CheckBox temp2 = (CheckBox) findViewById(R.id.creamTop);
        CheckBox temp3 = (CheckBox) findViewById(R.id.chocTop);
        if(temp2.isChecked() && temp3.isChecked()){
            body = ("ORDER SUMMARY : \n\nNAME : " + getName() +
                    "\n" +
                    "QUANTITY : " +
                    number / 5 +
                    "\n" +
                    "WHIPPED CREAM : $10" +
                    "\n" +
                    "CHOCOLATE TOPPINGS : $10" +
                    "\n" +
                    "TOTAL : $" +
                    (number + 20) +
                    "\n" +
                    "THANK YOU!!");
        } else if((temp2.isChecked() && !(temp3.isChecked())) || (temp3.isChecked() && !(temp2.isChecked()))){
            body = ("ORDER SUMMARY : \n\nNAME : " + getName() +
                    "\n" +
                    "QUANTITY : " +
                    number / 5 +
                    "\n" +
                    "WHIPPED CREAM : $10" +
                    "\n" +
                    "TOTAL : $" +
                    (number + 10) +
                    "\n" +
                    "THANK YOU!!");
        }

        else {
            body = ("ORDER SUMMARY : \n\nNAME : " + getName() +
                    "\n" +
                    "QUANTITY : " +
                    number / 5 +
                    "\n" +
                    "TOTAL : $" +
                    number +
                    "\n" +
                    "THANK YOU!!");
        }

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "greetings from ANONYMOUS");
        intent.putExtra(Intent.EXTRA_TEXT, "" + body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /*
     * called by "submitOrder" method
     * extracts the name of the user from editText
     * stores the name in a variable
     */
    private String getName(){

        EditText temp = (EditText) findViewById(R.id.name);
        return temp.getText().toString().toUpperCase();

    }

    /*
     * called by increment and decrement method
     * updates the quantity view with updated quantity
     */
    private void displayQuantity(int number){

        TextView temp = (TextView) findViewById(R.id.quan);
        temp.setText("" + number);

    }

}
