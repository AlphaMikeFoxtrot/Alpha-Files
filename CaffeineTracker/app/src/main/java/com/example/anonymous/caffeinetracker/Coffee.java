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
    Intent toBruS;
    Intent toBruM;
    Intent toBruL;
    float ratio = 3/5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        list = (ListView) findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, coffeeList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(this);

        toBruL = new Intent(this, BruLarge.class);
        toBruM = new Intent(this, BruMedium.class);
        toBruS = new Intent(this, BruSmall.class);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tempTextView = (TextView) view;
        switch (position){

            case 0:
                toBruS.putExtra("MG", 2.9);
                toBruS.putExtra("RATIO", ratio);
                startActivity(toBruS);
                break;

            case 1:
                toBruM.putExtra("MG", 5.6);
                toBruS.putExtra("RATIO", ratio);
                startActivity(toBruM);
                break;

            case 2:
                toBruL.putExtra("MG", 9.6);
                toBruS.putExtra("RATIO", ratio);
                startActivity(toBruL);
                break;

        }
    }
}
