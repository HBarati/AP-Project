package com.example.haclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class JoinClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("JOIN CLASS");
        setContentView(R.layout.activity_join_class);

        ////////////back button
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ///////////////////////

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.classes_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.Join){
            Toast.makeText(this, "Joining", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.Refresh_JoinClass_Item){
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.AboutUs_JoinClass_Item){
            Intent intent6 = new Intent(JoinClass.this, AboutUs.class);
            startActivity(intent6);
        }
        /////back Button
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        ///////////////
        return super.onOptionsItemSelected(item);
    }
}
