package com.example.athleticssports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Teams extends AppCompatActivity {

    CardView cardViewRegisterTeam,cardViewViewTeams, cardViewRegisterAthlete,cardViewViewAthlete,cardViewRegisterRace, cardViewSetRace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);


        cardViewRegisterTeam = (CardView)findViewById(R.id.register_teams);
        cardViewRegisterTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTeamRegistration();
            }
        });


//        cardViewViewTeams = (CardView)findViewById(R.id.view_teams);
//        cardViewViewTeams.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openViewTeams();
//            }
//        });


        cardViewRegisterAthlete = (CardView)findViewById(R.id.register_athlete);
        cardViewRegisterAthlete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterAthlete();
            }
        });


        cardViewViewAthlete = (CardView)findViewById(R.id.view_athlete);
        cardViewViewAthlete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewAthlete();
            }
        });


        cardViewRegisterRace = (CardView)findViewById(R.id.register_race);
        cardViewRegisterRace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterRace();
            }
        });


        cardViewSetRace = (CardView)findViewById(R.id.set_race);
        cardViewSetRace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetRace();
            }
        });





    }

    public void openTeamRegistration(){
        Intent intent = new Intent(this, RegisterTeam.class);
        startActivity(intent);
    }

//    public void openViewTeams(){
//        Intent intent = new Intent(this, RegisterTeam.class);
//        startActivity(intent);
//    }

    public void openRegisterAthlete(){
        Intent intent = new Intent(this, RegisterAthlete.class);
        startActivity(intent);
    }

    public void openViewAthlete(){
        Intent intent = new Intent(this, players.class);
        startActivity(intent);
    }

    public void openSetRace(){
        Intent intent = new Intent(this, Time.class);
        startActivity(intent);
    }

    public void openRegisterRace(){
        Intent intent = new Intent(this, RegisterRace.class);
        startActivity(intent);
    }
}
