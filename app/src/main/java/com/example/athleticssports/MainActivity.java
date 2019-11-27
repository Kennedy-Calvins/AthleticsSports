package com.example.athleticssports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView cardViewProfile,cardViewTeams, cardViewStats, cardViewRecords,
             cardViewAthleteComparison,cardViewLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViewProfile = (CardView)findViewById(R.id.Cardprofile);
        cardViewTeams = (CardView)findViewById(R.id.Cardteams);
        cardViewStats = (CardView)findViewById(R.id.CardStats);
        cardViewRecords = (CardView)findViewById(R.id.CardRecords);
        cardViewAthleteComparison = (CardView)findViewById(R.id.CardAthlete_Comparison);
        cardViewLogout = (CardView)findViewById(R.id.CardLogout);

        cardViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });

        cardViewTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTeams();
            }
        });

//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openStats();
//            }
//        });

        cardViewRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecords();
            }
        });

        cardViewAthleteComparison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAthleteComparison();
            }
        });


    }

    public void openProfile(){
        Intent intent = new Intent(MainActivity.this,MyProfile.class);
        startActivity(intent);

    }

    public void openTeams(){
        Intent intent = new Intent(MainActivity.this,Teams.class);
        startActivity(intent);

    }

//    public void openStats(){
//        Intent intent = new Intent(MainActivity.this,Stats.class);
//        startActivity(intent);
//
//    }

    public void openRecords(){
        Intent intent = new Intent(MainActivity.this,Records.class);
        startActivity(intent);

    }

    public void openAthleteComparison(){
        Intent intent = new Intent(MainActivity.this,AthleteComparison.class);
        startActivity(intent);

    }
}
