package com.example.athleticssports;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Time extends AppCompatActivity {
    Button btnstart, btnstop;
    ImageView icanchor;
    Animation atg,roundingalone;
    Chronometer timeHere;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        btnstart = findViewById(R.id.btn_start_race);
        btnstop = findViewById(R.id.btn_stop_race);
        icanchor = findViewById(R.id.icacnhor);
        timeHere = findViewById(R.id.timerHere);

        //create optional animation
        btnstop.setAlpha(0);


        //Load animations
        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        roundingalone = AnimationUtils.loadAnimation(this,R.anim.roundingalone);

        //import font
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");

        //customize font
        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing animation
                icanchor.startAnimation(roundingalone);
                btnstart.animate().alpha(0).setDuration(300).start();
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();

                //start time here
                timeHere.setBase(SystemClock.elapsedRealtime());
                timeHere.start();

            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing animation
                icanchor.clearAnimation();
                //stop time here
                timeHere.stop();
            }
        });

    }
}
