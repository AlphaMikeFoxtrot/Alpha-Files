package com.example.anonymous.caffeinetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;

public class Coffee extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView list;
    String[] coffeeList = {"BRU small", "BRU medium", "BRU large"};
    Intent toBru;
    Intent toNewCoffee;
    float ratio = 3/5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        list = (ListView) findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, coffeeList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(this);

        toBru = new Intent(this, aBru.class);
        toNewCoffee = new Intent(this, coffee_scroll.class);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tempTextView = (TextView) view;
        switch (position){

            case 0:
                toBru.putExtra("MG", 2.9);
                toBru.putExtra("RATIO", ratio);
                startActivity(toNewCoffee);
                break;

            case 1:
                toBru.putExtra("MG", 5.6);
                toBru.putExtra("RATIO", ratio);
                startActivity(toNewCoffee);
                break;

            case 2:
                toBru.putExtra("MG", 9.6);
                toBru.putExtra("RATIO", ratio);
                startActivity(toNewCoffee);
                break;

        }
    }
}
