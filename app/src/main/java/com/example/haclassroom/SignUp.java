package com.example.haclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SignUp extends AppCompatActivity {

    TextView name ;
    TextView pass;
    Button SignUpButton;
    int success;
    Button SignUp_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.Signup_Name);
        pass = findViewById(R.id.Signup_password);

        String Name = name.getText().toString();
        String Pass = pass.getText().toString();

        //////// Alert Empty
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean b) {
                if (name.getText().toString().trim().equals("")) {
                    name.setError("Please enter username");
                }
            }
        });

        pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean b) {
                if (pass.getText().toString().trim().equals("")) {
                    pass.setError("Please enter password");
                }
                else if (pass.getText().toString().length()<=5) {
                    pass.setError("Password is too short");
                }
            }
        });
        /////////////////////
        SignUpButton = findViewById(R.id.Signupsignup_button);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(SignUp.this, Classes.class);
                startActivity(intent5);
            }
        });
    }


}
