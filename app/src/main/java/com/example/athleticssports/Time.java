package com.example.athleticssports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
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
    private NotificationManager mNotifyManager;
    private	static final int NOTIFICATION_ID = 0;
    private PendingIntent notificationPendingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        //	Instantiating the NotificationManager in using getSystemService()
        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        btnstart = (Button) findViewById(R.id.btn_start_race);
        btnstop = (Button) findViewById(R.id.btn_stop_race);
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

        btnstart.setEnabled(true);



        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing animation
                icanchor.startAnimation(roundingalone);
                btnstart.animate().alpha(0).setDuration(300).start();
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();

                //notification
                sendNotification();
//                notify();



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
    public void sendNotification(){

        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Athletics Sports")
                .setContentText("The race has began.")
                .setSmallIcon(R.drawable.mtuwetu)
                .setContentIntent(notificationPendingIntent);

        Notification myNotification	= notifyBuilder.build();
        mNotifyManager.notify(NOTIFICATION_ID, myNotification);


        //Sets up the pending intent that is delivered when the notification is clicked
        Intent notificationIntent =	new	Intent(this, Time.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,
                NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //Delivers the notification

        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());





    }
}
