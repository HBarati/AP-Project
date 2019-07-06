package com.example.haclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Jozeiat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jozeiat);

        ////////////back button
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ///////////////////////
    }
}
