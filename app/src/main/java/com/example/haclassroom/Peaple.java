package com.example.haclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Peaple extends AppCompatActivity {

    List<MyPeaple>  myPeaple;
    ListView listView;
    PeapleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Peaple");
        setContentView(R.layout.activity_peaple);

        ////////////back button
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ///////////////////////

        listView = findViewById(R.id.PeapleList);
        myPeaple = new ArrayList<>();

        setData();
        ShowThePeaple();
    }

    private void setData() {
        //////Server
        myPeaple.add(new MyPeaple("Ali Alavi","Teacher"));
        myPeaple.add(new MyPeaple("Ali Naghavi","Teacher"));
        myPeaple.add(new MyPeaple("Hasan Hasani","Student"));
        myPeaple.add(new MyPeaple("Hasan Hoseini","Student"));
    }

    private void ShowThePeaple() {
        adapter = new PeapleAdapter(this,myPeaple);
        listView.setAdapter((ListAdapter) adapter);
    }


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
            Intent intent14 = new Intent(Peaple.this, AboutUs.class);
            startActivity(intent14);
        }
        if (item.getItemId()==R.id.Classes_Classpage_Item){
            Intent intent15 = new Intent(Peaple.this, Classes.class);
            startActivity(intent15);
        }
        return super.onOptionsItemSelected(item);
    }
}
