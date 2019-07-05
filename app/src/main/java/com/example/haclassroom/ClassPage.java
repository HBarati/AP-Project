package com.example.haclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ClassPage extends AppCompatActivity {

    Button PeapleBTN;
    Button ClassWorkBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Class Page");
        setContentView(R.layout.activity_class_page);

        PeapleBTN = findViewById(R.id.button8);
        ClassWorkBTN = findViewById(R.id.button9);

        ClassWorkBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent14 = new Intent(ClassPage.this, ClassWork.class);
                startActivity(intent14);
            }
        });

        PeapleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent15 = new Intent(ClassPage.this, Peaple.class);
                startActivity(intent15);
            }
        });

        ////////////back button
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ///////////////////////

    }



    /////////menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.classpage_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.Refresh_Classpage_Item) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.AboutUs_Classpage_Item){
            Intent intent12 = new Intent(ClassPage.this, AboutUs.class);
            startActivity(intent12);
        }
        if (item.getItemId()==R.id.Classes_Classpage_Item){
            Intent intent13 = new Intent(ClassPage.this, Classes.class);
            startActivity(intent13);
        }
        return super.onOptionsItemSelected(item);
    }
    /////////////
}
