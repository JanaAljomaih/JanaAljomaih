
package com.example.hhr_project;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Search extends AppCompatActivity {

    ConstraintLayout expandableView,expandableView1,expandableView12,expandableView13,expandableView14;
    Button arrowBtn,arrowBtn1,arrowBtn12,arrowBtn13,arrowBtn14,backbutton;
    CardView cardView,cardView1,cardView12,cardView13,cardView14;


    private void setupCardView(final ConstraintLayout expandableView, Button arrowBtn, final CardView cardView,RadioGroup radioGroupOptions  ,TextView textViewOptionDescription , Button buttonSelect) {

        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        radioGroupOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                textViewOptionDescription.setVisibility(View.VISIBLE);
                buttonSelect.setVisibility(View.VISIBLE);
                // Customize text based on the selected radio button
                if (checkedId == R.id.radioButtonOptionOne) {
                    textViewOptionDescription.setText("- Budget-friendly option\n" +
                            "- Comfortable travel experience\n" +
                            "- Affordable price");
                } else if (checkedId == R.id.radioButtonOptionTwo) {
                    textViewOptionDescription.setText("- Special promotional fare\n" +
                            "- Limited-time offer\n" +
                            "- Additional benefits over standard economy fare");
                }
            }
        });

        buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo Handle select button click
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        expandableView = findViewById(R.id.expandableView);
        arrowBtn = findViewById(R.id.arrowBtn);
        cardView = findViewById(R.id.cardView);
        RadioGroup radioGroupOptions = expandableView.findViewById(R.id.radioGroupOptions);
        TextView textViewOptionDescription = expandableView.findViewById(R.id.textViewOptionDescription);
        Button buttonSelect = expandableView.findViewById(R.id.buttonSelect);
        setupCardView(expandableView, arrowBtn, cardView,radioGroupOptions,textViewOptionDescription,buttonSelect);

        expandableView1 = findViewById(R.id.expandableView1);
        arrowBtn1 = findViewById(R.id.arrowBtn1);
        cardView1 = findViewById(R.id.cardView1);
        RadioGroup radioGroupOptions1 = expandableView1.findViewById(R.id.radioGroupOptions1);
        TextView textViewOptionDescription1 = expandableView1.findViewById(R.id.textViewOptionDescription1);
        Button buttonSelect1 = expandableView1.findViewById(R.id.buttonSelect1);
        setupCardView(expandableView1, arrowBtn1, cardView1,radioGroupOptions1,textViewOptionDescription1,buttonSelect1);


        expandableView12 = findViewById(R.id.expandableView12);
        arrowBtn12 = findViewById(R.id.arrowBtn12);
        cardView12 = findViewById(R.id.cardView12);
        RadioGroup radioGroupOptions12 = expandableView12.findViewById(R.id.radioGroupOptions12);
        TextView textViewOptionDescription12 = expandableView12.findViewById(R.id.textViewOptionDescription12);
        Button buttonSelect12 = expandableView12.findViewById(R.id.buttonSelect12);
        setupCardView(expandableView12, arrowBtn12, cardView12,radioGroupOptions12,textViewOptionDescription12,buttonSelect12);

        expandableView13 = findViewById(R.id.expandableView13);
        arrowBtn13 = findViewById(R.id.arrowBtn13);
        cardView13 = findViewById(R.id.cardView13);
        RadioGroup radioGroupOptions13 = expandableView13.findViewById(R.id.radioGroupOptions13);
        TextView textViewOptionDescription13 = expandableView13.findViewById(R.id.textViewOptionDescription13);
        Button buttonSelect13 = expandableView13.findViewById(R.id.buttonSelect13);
        setupCardView(expandableView13, arrowBtn13, cardView13,radioGroupOptions13,textViewOptionDescription13,buttonSelect13);

        expandableView14 = findViewById(R.id.expandableView14);
        arrowBtn14 = findViewById(R.id.arrowBtn14);
        cardView14 = findViewById(R.id.cardView14);
        RadioGroup radioGroupOptions14 = expandableView14.findViewById(R.id.radioGroupOptions14);
        TextView textViewOptionDescription14 = expandableView14.findViewById(R.id.textViewOptionDescription14);
        Button buttonSelect14 = expandableView14.findViewById(R.id.buttonSelect14);
        setupCardView(expandableView14, arrowBtn14, cardView14,radioGroupOptions14,textViewOptionDescription14,buttonSelect14);
;
        backbutton=findViewById(R.id.backbutton);
        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        arrowBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView1.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView1, new AutoTransition());
                    expandableView1.setVisibility(View.VISIBLE);
                    arrowBtn1.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView1, new AutoTransition());
                    expandableView1.setVisibility(View.GONE);
                    arrowBtn1.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });


        arrowBtn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView12.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView12, new AutoTransition());
                    expandableView12.setVisibility(View.VISIBLE);
                    arrowBtn12.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView12, new AutoTransition());
                    expandableView12.setVisibility(View.GONE);
                    arrowBtn12.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        arrowBtn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView13.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView13, new AutoTransition());
                    expandableView13.setVisibility(View.VISIBLE);
                    arrowBtn13.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView13, new AutoTransition());
                    expandableView13.setVisibility(View.GONE);
                    arrowBtn13.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        arrowBtn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView14.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView14, new AutoTransition());
                    expandableView14.setVisibility(View.VISIBLE);
                    arrowBtn14.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView14, new AutoTransition());
                    expandableView14.setVisibility(View.GONE);
                    arrowBtn14.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });
        ///directed to seat class
        buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Search.this, Seat.class));//redirect to other page
            }
        });//end link
        buttonSelect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Search.this, Seat.class));//redirect to other page
            }
        });//end link
        buttonSelect12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Search.this, Seat.class));//redirect to other page
            }
        });//end link
        buttonSelect13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Search.this, Seat.class));//redirect to other page
            }
        });//end link
        buttonSelect14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Search.this, Seat.class));//redirect to other page
            }
        });//end link

        ///back button

        backbutton.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                       startActivity(i);
                                   }
                               }
        );



   }//ennd of on create
}