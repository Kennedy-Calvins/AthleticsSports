package com.example.athleticssports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class players extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("AthleteDetails");
        databaseReference.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HashMap<String, String> athletesMap = (HashMap)dataSnapshot.getValue();
                for(HashMap.Entry<String, String> entry : athletesMap.entrySet()){
                    String athleteName = entry.getValue();
                    Log.d("DATA", athleteName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("DATA",databaseError.getMessage());
            }
        });

    }

    private ArrayList<Athlete>getMyList(){

        ArrayList<Athlete>models=new ArrayList<>();

        Athlete m = new Athlete();
        m.setAthletename("Kennedy Calvins");
        m.setPhoneNumber("Real Madrid");

        m.setImg(R.drawable.avatar);
        models.add(m);

        m = new Athlete();
        m.setAthletename("Badiabdi");
        m.setPhoneNumber("Real Betis");

        m.setImg(R.drawable.logoapp);
        models.add(m);

        m = new Athlete();
        m.setAthletename("Jabez Magomere");
        m.setPhoneNumber("Barcelona");

        m.setImg(R.drawable.mtu);
        models.add(m);

        return models;
    }
}
