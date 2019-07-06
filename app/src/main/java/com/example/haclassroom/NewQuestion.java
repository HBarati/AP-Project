package com.example.haclassroom;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class NewQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("");
        setContentView(R.layout.activity_new_question);

        ////////////back button
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ///////////////////////
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            menu.add("Send").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    Toast.makeText(NewQuestion.this, "Sending Complite", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(NewQuestion.this,ClassWork.class));
                    return false;
                }
            }).setShowAsAction(1);


            menu.add("Attach").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    Toast.makeText(NewQuestion.this, "Cant Attach a file ", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }).setShowAsAction(1);

        menu.add("Cancle").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(NewQuestion.this, "Cancling", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(NewQuestion.this,ClassWork.class));
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
            Intent intent14 = new Intent(NewQuestion.this, AboutUs.class);
            startActivity(intent14);
        }
        if (item.getItemId()==R.id.Classes_Classpage_Item){
            Intent intent15 = new Intent(NewQuestion.this, Classes.class);
            startActivity(intent15);
        }
        return super.onOptionsItemSelected(item);
    }

    public void Topics(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ////////give topic list from Server
        final String[] strings = new String[]{"No Topic",
                "Topoc one",
                "Topic two",
                "Topic three"};
        builder.setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
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
    public void Date(final View view){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(NewQuestion.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date = String.format("@02d/@02d/@04d",day,month,year);
                TextView textView = findViewById(R.id.editText10);
                textView.setText(date);
            }
        },year,month,day);
        datePickerDialog.show();
    }
}
