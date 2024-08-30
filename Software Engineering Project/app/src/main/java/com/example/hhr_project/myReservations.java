package com.example.hhr_project;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class myReservations extends AppCompatActivity {
    Button fnav,snav,tnav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*signLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));//redirect to other page
            }
     });//end link*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reservations);

        // Finding buttons by their IDs
        //Now
        Button jeddahToMeccaNowButton = findViewById(R.id.jeddahToMeccaNow);
        Button meccaToJeddahNowButton = findViewById(R.id.MeccatoJeddahNow);
        //previous
        Button jeddahToMadinaButton = findViewById(R.id.jeddahtoMadina);
        Button alsulaimaniyahToAirportButton = findViewById(R.id.AlsulaimaniyahtoAIRPORT);
        Button kaecToMadinahButton = findViewById(R.id.KAECtoMadinah);
        Button madinahToKaecButton = findViewById(R.id.MadinahtoKAEC);
        Button meccaToJeddahButton = findViewById(R.id.MeccatoJeddah);
        Button jeddahToMeccaButton = findViewById(R.id.JeddahtoMecca);



        // Setting click listeners for each button
        jeddahToMeccaNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo("Jeddah to Mecca Now");
            }
        });

        meccaToJeddahNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo("Mecca to Jeddah Now");
            }
        });

        jeddahToMadinaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo("Jeddah to Mecca");
            }
        });

        alsulaimaniyahToAirportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo("Alsulaimaniyah to Airport");
            }
        });

        kaecToMadinahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo("KAEC to Madinah");
            }
        });

        madinahToKaecButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo("Madinah to KAEC");
            }
        });

        meccaToJeddahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo("Mecca to Jeddah");
            }
        });

        jeddahToMeccaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo("Jeddah to Mecca");
            }
        });


        Button editButton1 = findViewById(R.id.Edit1);
        Button editButton2 = findViewById(R.id.Edit2);

//        editButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Open resertest.xml
//                Intent intent = new Intent(myReservations.this, ReserTest.class);
//                startActivity(intent);
//            }
//        });

//        editButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Open resertest.xml
//                Intent intent = new Intent(myReservations.this, ReserTest.class);
//                startActivity(intent);
//            }
//        });


        fnav=  findViewById(R.id.firstNav);
        fnav.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(i);
                                    }
                                }
        );


        snav=  findViewById(R.id.secondNavg);
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




    // Method to display information based on button clicked
    private void displayInfo(String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }
}