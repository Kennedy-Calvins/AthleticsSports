package com.example.athleticssports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewTeam extends AppCompatActivity {

    DatabaseReference ref;
    ArrayList<AthleteDetails>list;
    RecyclerView recyclerView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_team);

        ref = FirebaseDatabase.getInstance().getReference().child("athleticssports-8d901").child("AthleteDetails");
        recyclerView = findViewById(R.id.rv);
        searchView = findViewById(R.id.searchView);
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(ref != null){

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if(dataSnapshot.exists()){
                        for (DataSnapshot ds:dataSnapshot.getChildren()){
                            list.add(ds.getValue(AthleteDetails.class));

                        }
                        AdapterClass adapterClass = new AdapterClass(list);
                        recyclerView.setAdapter(adapterClass);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(ViewTeam.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }

        if (searchView != null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return true;
                }
            });
        }
    }

    private void search(String str){
        ArrayList<AthleteDetails> mylist = new ArrayList<>();
        for (AthleteDetails object: list){
            if (object.getAthleteName().toLowerCase().contains(str.toLowerCase())){

                mylist.add(object);

            }
        }

        AdapterClass adapterClass =  new AdapterClass(mylist);
        recyclerView.setAdapter(adapterClass);
    }
}
