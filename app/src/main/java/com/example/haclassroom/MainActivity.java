package com.example.haclassroom;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onRestart() {
        super.onRestart();
        logInButton.setText("Log IN");
    }

    TextView name;
    TextView pass;
    Button logInButton;
    Button SignUpButton;
    static String success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("LOG IN");
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Welcome to your application!!", Toast.LENGTH_SHORT).show();

        name = findViewById(R.id.Name);
        pass = findViewById(R.id.Password);

        name.setTextColor(Color.rgb(00, 00, 00));
        String Name = name.getText().toString();
        String Pass = pass.getText().toString();

        logInButton = findViewById(R.id.button);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInButton.setText("Loging IN");
                if (success=="1") {
                Intent intent = new Intent(MainActivity.this, Classes.class);
                startActivity(intent);
                }
            }
        });
        SignUpButton = findViewById(R.id.SignUp_button);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent3);
            }
        });

        //////// Alert Empty
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (MainActivity.this.name.getText().toString().trim().equals("")) {
                    MainActivity.this.name.setError("Please enter username");
                }
            }
        });
        pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (pass.getText().toString().trim().equals("")) {
                    pass.setError("Please enter password");
                }
            }
        });
        /////////////////////
    }
    ///////Server
    public void Send(View v){
        MassegeSender massegeSender = new MassegeSender();
        String Sending = "SignUp:"+name+":"+pass;
        massegeSender.execute(Sending);
    }
    //////////////
}
