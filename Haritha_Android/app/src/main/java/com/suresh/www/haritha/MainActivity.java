package com.suresh.www.haritha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick_one(View v)
    {
        Intent i=new Intent(MainActivity.this,SelectMenu.class);
        startActivity(i);

    }
    public void onClick_two(View v)
    {
        Intent i=new Intent(MainActivity.this,CollectorCenter.class);
        startActivity(i);
    }
}
