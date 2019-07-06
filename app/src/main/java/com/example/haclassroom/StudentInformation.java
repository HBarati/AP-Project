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

public class StudentInformation extends AppCompatActivity {

    List<MyStudentQuestion> myStudentQuestions;
    ListView listView;
    MyStudentQuestionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Student Page");
        setContentView(R.layout.activity_student_information);

        ////////////back button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ///////////////////////

        listView = findViewById(R.id.StudentQuestion);
        myStudentQuestions = new ArrayList<>();

        setData();
        ShowTheQuestion();
    }

    private void setData() {
        /////////Server
        myStudentQuestions.add(new MyStudentQuestion("Question one","Mark One"));
        myStudentQuestions.add(new MyStudentQuestion("Question two","Mark two"));
        myStudentQuestions.add(new MyStudentQuestion("Question three","Mark three"));
    }

    private void ShowTheQuestion() {
        adapter = new MyStudentQuestionAdapter(this, myStudentQuestions);
        listView.setAdapter((ListAdapter) adapter);
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
            Intent intent26 = new Intent(StudentInformation.this, AboutUs.class);
            startActivity(intent26);
        }
        if (item.getItemId()==R.id.Classes_Classpage_Item){
            Intent intent27 = new Intent(StudentInformation.this, Classes.class);
            startActivity(intent27);
        }
        return super.onOptionsItemSelected(item);
    }
    /////////////
}
