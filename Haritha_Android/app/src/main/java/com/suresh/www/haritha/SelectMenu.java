package com.suresh.www.haritha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_menu);
    }
    public void onClick_one(View v)
    {
        Intent i=new Intent(SelectMenu.this,MapsActivity.class);
        startActivity(i);

    }
    public void onClick_on(View v)
    {
        Intent i=new Intent(SelectMenu.this,MapsActivity.class);
        startActivity(i);

    }
    public void onClick_o(View v)
    {
        Intent i=new Intent(SelectMenu.this,MapsActivity.class);
        startActivity(i);

    }
}
