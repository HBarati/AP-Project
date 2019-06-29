package com.example.haclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Classes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("CLASSES");
        setContentView(R.layout.activity_classes);

        Toast.makeText(this, "Welcome IN", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_classes,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.Refresh_Classes_Item) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.AboutUs_Classes_Item){
            Intent intent2 = new Intent(Classes.this, AboutUs.class);
            startActivity(intent2);
        }
        if (item.getItemId()==R.id.CreateClass_Classes_Item){
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.JoinClass_Classes_Item){
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

