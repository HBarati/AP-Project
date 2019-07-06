package com.example.haclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class StudentChanger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Student Manager");
        setContentView(R.layout.activity_student_changer);

        ////////////back button
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ///////////////////////
    }

    public void AddStudent(View view){
        Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show();
        Intent intent23 = new Intent(StudentChanger.this, Peaple.class);
        startActivity(intent23);
    }

    public void DeleteStudent(View view){
        Toast.makeText(this, "Student Deleted", Toast.LENGTH_SHORT).show();
        Intent intent24 = new Intent(StudentChanger.this, Peaple.class);
        startActivity(intent24);
    }
}
