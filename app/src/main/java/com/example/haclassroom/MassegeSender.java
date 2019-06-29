package com.example.haclassroom;

import android.os.AsyncTask;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MassegeSender extends AsyncTask <String,Void,Void>
{
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    @Override
    protected Void doInBackground(String... voids) {
        final String massage = voids[0];
        Thread threadWrite = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket("192.168.10.10", 7800);
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataOutputStream.writeUTF(massage);
                    dataOutputStream.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    String[] succes = dataInputStream.readUTF().split(":");
                    if (succes[0]=="LogIn") {
                        MainActivity.success = succes[1];
                    } else if (succes[0]=="SignUp") {
                        SignUp.successSignUp = succes[1];
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        return null;
    }
}
