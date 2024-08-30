package com.example.hhr_project;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class SignUp extends AppCompatActivity {

    EditText signPass, signPassConf,Signemail,signId,signPhone,signAge,signName;
    TextView LogLink;
    Button signBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signPass = findViewById(R.id.SignPassword);
        signPassConf = findViewById(R.id.SignPasswordConform);
        Signemail = findViewById(R.id.SignEmail);

        signPhone = findViewById(R.id.SignPhone);
        signName = findViewById(R.id.SignUserName);
        signBtn = findViewById(R.id.SignBtn);
        signAge = findViewById(R.id.SignAge);
        signId = findViewById(R.id.SignId);
        LogLink = findViewById(R.id.LogLink);

        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempemail = Signemail.getText().toString();
                String temppassconf = signPassConf.getText().toString();
                String temppass = signPass.getText().toString();
                String tempPhone = signPhone.getText().toString();

                String tempname = signName.getText().toString();
                String tempAge = signAge.getText().toString();
                String tempId = signId.getText().toString();
                //DB
                DB db=new DB(getApplicationContext(),"HHR",null,1);

                if (tempemail.length() == 0 || temppass.length() == 0 || temppassconf.length() == 0 || temppass.length() == 0 ||
                        tempPhone.length() == 0 || tempname.length() == 0 || tempAge.length() == 0 || tempId.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (temppass.compareTo(temppassconf) == 0) {

                        if (isValidPassword(temppass)) {
                            // Password is valid
                            Toast.makeText(SignUp.this, "Password is valid", Toast.LENGTH_SHORT).show();

                            String hashedPassword = hashPassword(temppass);
                            if (hashedPassword != null) {
                                // Password hashed successfully
                                // Now you can use the hashedPassword for storage or comparison
                                // For example, you can send it to a server for authentication
                                // Toast.makeText(SignUp.this, "Password hashed successfully", Toast.LENGTH_SHORT).show();
                                db.addUser(tempname,tempemail,tempPhone,tempId,temppass,Integer.parseInt(tempAge) );
                                Toast.makeText(SignUp.this, "welcome "+tempname, Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this, MainActivity.class));
                            } else {
                                // Password hashing failed
                                // Handle the error appropriately
                                Toast.makeText(SignUp.this, "Password hashing failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Password is invalid
                            Toast.makeText(SignUp.this, "Password At least 8 characters long\n" +
                                    " Contains at least one uppercase letter\n" +
                                    "   Contains at least one lowercase letter\n" +
                                    "  Contains at least one digit\n" +
                                    "   Contains at least one special character ", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(SignUp.this, "Password and conform Password is not match ", Toast.LENGTH_SHORT).show();

                    }
                }
            }

        });//btn method
        LogLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Login.class));//redirect to other page
            }
        });//end link
    }
    private boolean isValidPassword(String password) {
        // Criteria for validation:
        // - At least 8 characters long
        // - Contains at least one uppercase letter
        // - Contains at least one lowercase letter
        // - Contains at least one digit
        // - Contains at least one special character

        // Regular expression for password validation
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

        // Check if the password matches the pattern
        return password.matches(pattern);
    }
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

}//end class







