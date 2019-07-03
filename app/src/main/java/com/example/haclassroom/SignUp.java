package com.example.haclassroom;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class SignUp extends AppCompatActivity {

    TextView name ;
    TextView pass;
    Button SignUpButton;
    static String successSignUp;
    Button SignUp_Button;
    ImageView SignUP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("SIGN UP");
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.Signup_Name);
        pass = findViewById(R.id.Signup_password);

        final String Name = name.getText().toString();
        String Pass = pass.getText().toString();
        SignUP = findViewById(R.id.SignUp_imageView);
        SignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(Intent.ACTION_GET_CONTENT);
                intent9.addCategory(intent9.CATEGORY_OPENABLE);
                intent9.setType("image/*");
                startActivityForResult(intent9.createChooser(intent9,"Choose a picture:"), 1);
            }
        });

        ////////////back button
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ///////////////////////

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
                if (successSignUp=="1") {
                    Intent intent5 = new Intent(SignUp.this, Classes.class);
                    intent5.putExtra("UserName", Name);
                    startActivity(intent5);
                }
            }
        });
    }

    ////////////back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    ///////////////////////

    public void SendSignUp(View v){
        MassegeSender massegeSender = new MassegeSender();
        String Sending = "SignUp:"+name+":"+pass;
        massegeSender.execute(Sending);
    }

    //////image

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == 1){
                Uri imageUri = data.getData();
                final String path = getPathFromURI(imageUri);
                if (path != null){
                    File file = new File(path);
                    imageUri = Uri.fromFile(file);
                }

                SignUP.setImageURI(imageUri);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getPathFromURI(Uri contenturi){
        String res = null;
        String[] project = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contenturi,project,null,null,null);
        if (cursor.moveToFirst()){
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }
    ///////////

}
