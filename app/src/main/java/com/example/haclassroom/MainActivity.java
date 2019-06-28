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

    TextView textView ;
    TextView pass ;
    Button logInButton;
    int success ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Welcome to your application!!", Toast.LENGTH_SHORT).show();

        textView = findViewById(R.id.Name);
        pass = findViewById(R.id.Password);

        textView.setTextColor(Color.rgb(00,00,00));
        String name = textView.getText().toString();
        String Pass = pass.getText().toString();

        try{
            Socket socket = new Socket("192.168.0.1", 5001);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(socket.getInputStream());

            printWriter.write("Log In "+name+" "+Pass);
            printWriter.flush();
            success = scanner.nextInt();
        }catch (IOException e){
            e.printStackTrace();
        }

        logInButton = findViewById(R.id.button);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInButton.setText("Loging IN");
                if (success==1) {
                    Intent intent = new Intent(MainActivity.this, Classes.class);
                    startActivity(intent);
                }
            }
        });

    }

}
