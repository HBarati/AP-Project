package com.example.haclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CreateClass extends AppCompatActivity {

    TextView className;
    TextView section;
    TextView room;
    TextView subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("CREATE CLASS");
        setContentView(R.layout.activity_create_class);

        ////////////back button
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ///////////////////////

        className = findViewById(R.id.ClassName);
        section = findViewById(R.id.Section);
        room = findViewById(R.id.Room);
        subject = findViewById(R.id.Subject);

        //////// Alert Empty
        className.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (className.getText().toString().trim().equals("")) {
                    className.setError("Please enter class name");
                }
            }
        });
        room.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (room.getText().toString().trim().equals("")) {
                    room.setError("Please enter room");
                }
            }
        });
        /////////////////////
    }

    //////////////Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.classes_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.create){
            Toast.makeText(this, "Creating", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.cansel){
            Intent intent9 = new Intent(CreateClass.this,Classes.class);
            startActivity(intent9);
        }
        if (item.getItemId()==R.id.Refresh_CreateClass_Item){
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.AboutUs_CreateClass_Item){
            Intent intent8 = new Intent(CreateClass.this, AboutUs.class);
            startActivity(intent8);
        }
        /////back Button
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        ///////////////
        return super.onOptionsItemSelected(item);
    }
    ////////////////////


}
