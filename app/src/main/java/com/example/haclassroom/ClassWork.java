package com.example.haclassroom;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ClassWork extends AppCompatActivity {

    String Mood;
    List<MyClassWork> myClassWorks;
    ListView listView;
    ClassWorkAdapter adapter;

    @Override
    protected void onRestart() {
        super.onRestart();

    }

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

        listView = findViewById(R.id.ClassWorkList);
        myClassWorks = new ArrayList<>();

        setData();
        ShowTheClassWorks();

    }

    private void setData() {
        //////Server
        myClassWorks.add(new MyClassWork("class one","Topic one"));
        myClassWorks.add(new MyClassWork("class two","Topic two"));
        myClassWorks.add(new MyClassWork("class three","Topic three"));
    }

    private void ShowTheClassWorks() {
        adapter = new ClassWorkAdapter(this,myClassWorks);
        listView.setAdapter(adapter);
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

    public void TopicChange(View view){
        Intent intent18 = new Intent(ClassWork.this, TopicChanger.class);
        startActivity(intent18);
    }

    public void jozeiat(View view){
        Intent intent21 = new Intent(ClassWork.this, Jozeiat.class);
        startActivity(intent21);
    }

    public void fab(View view){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] strings = new String[]{"Question","Topic"};
        builder.setSingleChoiceItems(strings, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                /////Send Chois too server
                if (strings[i]=="Question") {
                    Intent intent22 = new Intent(ClassWork.this, NewQuestion.class);
                    startActivity(intent22);
                    builder.create().dismiss();
                }
                if (strings[i]=="Topic"){
                    Intent intent23 = new Intent(ClassWork.this, TopicChanger.class);
                    startActivity(intent23);
                    builder.create().dismiss();
                }
            }
        });
        builder.show();
        builder.create().dismiss();
    }

}
