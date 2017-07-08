package com.example.anonymous.waraapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toCredit(View view){
        setContentView(R.layout.credits);
    }

    public void toMain(View view){
        setContentView(R.layout.activity_main);
    }

    public void construction(View view){
        setContentView(R.layout.maintenance);
    }
}
