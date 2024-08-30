package com.example.hhr_project;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Personalinfo extends AppCompatActivity {
    Button editButton,logoutButton,fnav,snav,tnav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);

        // Find the "Edit" button by its ID
         editButton = findViewById(R.id.button2);

        // Set a click listener for the "Edit" button
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your logic to handle the edit functionality here
                Toast.makeText(Personalinfo.this, "Edit button clicked", Toast.LENGTH_SHORT).show();
                // You can start another activity for editing the information, show a dialog, etc.
            }
        });

        // Find the "Log out" button by its ID
         logoutButton = findViewById(R.id.buttonout);

        // Set a click listener for the "Log out" button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your logic to handle the logout functionality here
                Toast.makeText(Personalinfo.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
                // You can log out the user, clear session data, navigate to the login screen, etc.
                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);



            }
        });

        fnav=  findViewById(R.id.firstNav);
        fnav.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(i);
                                    }
                                    }
                );


        snav=  findViewById(R.id.secondNav);
        snav.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(getApplicationContext(),myReservations.class);
                                        startActivity(i);
                                    }
                                }
        );



        tnav=  findViewById(R.id.thirddNav);
        tnav.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(getApplicationContext(),Personalinfo.class);
                                        startActivity(i);
                                    }
                                }
        );






    }
}