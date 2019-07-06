package com.example.haclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ClassWork extends AppCompatActivity {

    String Mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Class Work");
        setContentView(R.layout.activity_class_work);

        ////////////back button
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ///////////////////////

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Mood = "T";

        if (Mood.equals("T")) {
            menu.add("Setting").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    startActivity(new Intent(ClassWork.this,ClassSetting.class));
                    return false;
                }
            }).setShowAsAction(1);

        }
        if (Mood.equals("S")){
            menu.add("i").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    startActivity(new Intent(ClassWork.this,ClassInformation.class));
                    return false;
                }
            }).setShowAsAction(1);
        }

        getMenuInflater().inflate(R.menu.classpage_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.Refresh_Classpage_Item) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.AboutUs_Classpage_Item){
            Intent intent14 = new Intent(ClassWork.this, AboutUs.class);
            startActivity(intent14);
        }
        if (item.getItemId()==R.id.Classes_Classpage_Item){
            Intent intent15 = new Intent(ClassWork.this, Classes.class);
            startActivity(intent15);
        }
        return super.onOptionsItemSelected(item);
    }
}