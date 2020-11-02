package com.example.athleticssports;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class AthleteComparison extends AppCompatActivity{

    CardView cardViewplayerOne, cardViewplayerTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_comparison);

        cardViewplayerOne = (CardView)findViewById(R.id.selectplayerone);
        cardViewplayerTwo =(CardView)findViewById(R.id.selectplayer2);

        cardViewplayerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }


        });
        cardViewplayerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


}
