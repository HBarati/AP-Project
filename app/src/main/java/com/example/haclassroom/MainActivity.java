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
    int success;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Welcome to your application!!", Toast.LENGTH_SHORT).show();

        name = findViewById(R.id.Name);
        pass = findViewById(R.id.Password);

        name.setTextColor(Color.rgb(00, 00, 00));
        String Name = name.getText().toString();
        String Pass = pass.getText().toString();

        ///////Server
        try {
            Socket socket = new Socket("192.168.0.1", 5001);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(socket.getInputStream());

            printWriter.write("Log In " + Name + " " + Pass);
            printWriter.flush();
//            success = scanner.nextInt();
            success = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        ///////////////////

        logInButton = findViewById(R.id.button);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInButton.setText("Loging IN");
//                if (success==1) {
                Intent intent = new Intent(MainActivity.this, Classes.class);
                startActivity(intent);
//                }
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
                if (name.getText().toString().trim().equals("")) {
                    name.setError("Please enter username");
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
}
