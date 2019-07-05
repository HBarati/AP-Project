package com.example.haclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Classes extends AppCompatActivity {

    List<MyClasses> myClassesList;
    ListView listView;
    ClassesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("CLASSES");
        setContentView(R.layout.activity_classes);

        Toast.makeText(this, "Welcome IN", Toast.LENGTH_SHORT).show();

        listView = findViewById(R.id.ClassesList);
        myClassesList = new ArrayList<>();
        setData();
        ShowTheClasses();

    }

    private void setData() {
        myClassesList.add(new MyClasses("Teacher Class","T","15 student"));
        myClassesList.add(new MyClasses("Student Class","S","Ostad Ali"));
    }

    private void ShowTheClasses() {
        adapter = new ClassesAdapter(this,myClassesList);
        listView.setAdapter(adapter);
    }


    ////////
//    adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
//        adapter.notifyDataSetChanged();
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//        }
//    });
    ////////////

//    Bundle extras = getIntent().getExtras();
//    public String UserName = extras.getString("UserName");

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.classes_menu,menu);
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
            Intent intent10 = new Intent(Classes.this, CreateClass.class);
            startActivity(intent10);
        }
        if (item.getItemId()==R.id.JoinClass_Classes_Item){
            Intent intent7 = new Intent(Classes.this, JoinClass.class);
            startActivity(intent7);
        }
        return super.onOptionsItemSelected(item);
    }

    public void Click(View view){
        Intent intent11 = new Intent(Classes.this,ClassPage.class);
        startActivity(intent11);
    }
}

