package com.example.hhr_project;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login extends AppCompatActivity {

    EditText pass, email;
    TextView signLink;
    Button logBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pass = findViewById(R.id.LogPassword);
        email = findViewById(R.id.LogEmail);
        logBtn = findViewById(R.id.LogBtn);
        signLink = findViewById(R.id.SignLink);
        DB db=new DB(getApplicationContext(),"HHR",null,1);
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempemail = email.getText().toString();
                String temppass = pass.getText().toString();
                if (tempemail.length() == 0 || temppass.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    String hashedPassword = hashPassword(temppass);
                    //if (hashedPassword != null) {
                    if(db.login(tempemail,temppass)==1){
                        Toast.makeText(getApplicationContext(), "Log in success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, MainActivity.class));
                        // }

                    } else {
                        Toast.makeText(getApplicationContext(), "invalid email or password", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getApplicationContext(), "invalid email or password", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, MainActivity.class));

                }
            }
        });//btn method
        signLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));//redirect to other page
            }
        });//end link


    }

    //////////////////////////////
    private String hashPassword(String password) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Update the digest with the password bytes
            byte[] hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array to a hexadecimal string
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle NoSuchAlgorithmException if SHA-256 is not available
            e.printStackTrace();
            return null;
        }
    }
}//end of class
