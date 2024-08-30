package com.example.hhr_project;



import static com.example.hhr_project.R.id.spinnerFromb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.DatePicker;
import android.widget.EditText;
import android.app.DatePickerDialog;
import java.util.Calendar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;

import android.view.View.OnClickListener;





public class roundTrip extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    private Spinner spinner2;
    private EditText date;
    DatePickerDialog datePickerDialog;
    private static final String[] pathsTo = {"Makkah", "Alsulaimaniyah -Jeddah", "AIRPORT -Jeddah", "KAEC", "Madinah"};
    private static final String[] pathsFrom ={"Makkah", "Alsulaimaniyah -Jeddah", "AIRPORT -Jeddah", "KAEC", "Madinah"};

    private Button oneWayButton2, roundTripButton2;
    private static Context context;

    private Button oneWayButton, roundTripButton,fnav,snav,tnav,search_button;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_trip);

        spinner = (Spinner)findViewById(R.id.spinnerFromb);
        spinner2= (Spinner)findViewById(R.id.spinnerTob);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(roundTrip.this,
                android.R.layout.simple_spinner_item,pathsFrom);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(roundTrip.this,
                android.R.layout.simple_spinner_item,pathsTo);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);




        // initiate the date picker and a button
        date = (EditText) findViewById(R.id.date2);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(roundTrip.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        search_button=  findViewById(R.id.searchbtn2);

        oneWayButton=  findViewById(R.id.oneWayTripButton2);

        roundTripButton= findViewById(R.id.roundTripButton2) ;

        roundTripButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent i = new Intent(getApplicationContext(),roundTrip.class);
                                                   startActivity(i);
                                               }
                                           }
        );
        oneWayButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                                startActivity(i);
                                            }
                                        }
        );
//


//        Button oneWayButton=  findViewById(R.id.oneWayTrip1);
////        Button roundTripButton= (Button) findViewById(R.id.roundTripb);
//
//
//        oneWayButton.setOnClickListener(new View.OnClickListener() {
//                                               @Override
//                                               public void onClick(View v) {
//                                                   Intent i = new Intent(getApplicationContext(),MainActivity.class);
//                                                   startActivity(i);
//                                               }
//                                           }
//        );



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
                                });


        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Search.class);
                startActivity(i);
            }
        });



    }












    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }






}