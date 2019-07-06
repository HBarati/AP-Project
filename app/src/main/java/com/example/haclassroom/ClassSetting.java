package com.example.haclassroom;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ClassSetting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Class Setting");
        setContentView(R.layout.activity_class_setting);

        ////////////back button
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ///////////////////////
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("SAVE").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                //////Server conection
                Toast.makeText(ClassSetting.this, "Saving", Toast.LENGTH_SHORT).show();
                return false;
            }
        }).setShowAsAction(1);
        
        getMenuInflater().inflate(R.menu.classpage_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.Refresh_Classpage_Item) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.AboutUs_Classpage_Item){
            Intent intent14 = new Intent(ClassSetting.this, AboutUs.class);
            startActivity(intent14);
        }
        if (item.getItemId()==R.id.Classes_Classpage_Item){
            Intent intent15 = new Intent(ClassSetting.this, Classes.class);
            startActivity(intent15);
        }
        return super.onOptionsItemSelected(item);
    }

    public void ClassSetting_commentMood(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] strings = new String[]{"Students can post and comment",
                                                "Students can only comment",
                                                "Only teachers can post and comment"};
        builder.setSingleChoiceItems(strings, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                /////Send Chois too server
                TextView Stream = findViewById(R.id.Stream_Setting);
                Stream.setText(strings[i]);
            }
        });
        builder.setPositiveButton("OK",null);
        builder.show();
        builder.create().dismiss();
    }
}
