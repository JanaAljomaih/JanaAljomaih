package com.example.hhr_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
 import androidx.appcompat.app.AppCompatActivity;

        import android.app.ActionBar;
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
        import android.widget.TextView;
        import android.widget.Toast;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.app.DatePickerDialog;
        import java.util.Calendar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
        import androidx.annotation.NonNull;

        import android.view.View.OnClickListener;






public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    private Spinner spinner2;
    private EditText date;
    DatePickerDialog datePickerDialog;
    private static final String[] pathsTo = {"Makkah", "Alsulaimaniyah -Jeddah", "AIRPORT -Jeddah", "KAEC", "Madinah"};
    private static final String[] pathsFrom ={"Makkah", "Alsulaimaniyah -Jeddah", "AIRPORT -Jeddah", "KAEC", "Madinah"};

    private Button oneWayButton, roundTripButton,fnav,snav,tnav,btn;
    private static Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final ActionBar actionBar = getActionBar();
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        TextView titleTextView =new TextView(actionBar.getThemedContext());
//        titleTextView.setText("Book a trip");
////        titleTextView.setTypeface();
//        actionBar.setCustomView(titleTextView);

        spinner = (Spinner)findViewById(R.id.spinnerFrom);
        spinner2= (Spinner)findViewById(R.id.spinnerTo);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,pathsFrom);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,pathsTo);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);




        // initiate the date picker and a button
        date = (EditText) findViewById(R.id.date);
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
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        oneWayButton=  findViewById(R.id.oneWayTripButton);

        roundTripButton= findViewById(R.id.roundTripButton) ;

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
//        }
//
//        roundTripButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, round_trip_booking_trip.class);
//                startActivity(intent);
//            }
//
//
//        });


//
//        roundTripButton.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent i = new Intent(MainActivity.this,round_trip_booking_trip.class);
//                        startActivity(i);
//                    }
//                }
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


        btn=  findViewById(R.id.searchbtn);
        btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(getApplicationContext(),Search.class);
                                        startActivity(i);
                                    }
                                }
        );

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