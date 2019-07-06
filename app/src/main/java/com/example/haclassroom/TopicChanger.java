package com.example.haclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TopicChanger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add/Delete Toics");
        setContentView(R.layout.activity_topic_changer);

        ////////////back button
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ///////////////////////
    }

    public void AddTopic(View view){
        Toast.makeText(this, "Topic Added", Toast.LENGTH_SHORT).show();
        Intent intent19 = new Intent(TopicChanger.this, ClassWork.class);
        startActivity(intent19);
    }

    public void DeleteTopic(View view){
        Toast.makeText(this, "Topic Deleted", Toast.LENGTH_SHORT).show();
        Intent intent20 = new Intent(TopicChanger.this, ClassWork.class);
        startActivity(intent20);
    }
}
