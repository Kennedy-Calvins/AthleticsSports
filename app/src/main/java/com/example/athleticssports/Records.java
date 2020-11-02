package com.example.athleticssports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Records extends AppCompatActivity {

    //Spinner spinner;
    Spinner spinner, spinner1, spinner2, spinner3 ;
    FirebaseStorage storage;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    String textName = "";
    ValueEventListener listener;
    ArrayAdapter<String> adapter;
    ArrayList<String> spinnerDatalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        spinner = (Spinner) findViewById(R.id.spinner_county);
        spinner1 = (Spinner) findViewById(R.id.spinner_category);
        spinner2 = (Spinner) findViewById(R.id.spinner_gender);
        spinner3 = (Spinner)findViewById(R.id.spinner_marathon);

        databaseReference = FirebaseDatabase.getInstance().getReference("Counties");
        databaseReference = FirebaseDatabase.getInstance().getReference("Category");
        databaseReference = FirebaseDatabase.getInstance().getReference("Gender");
        databaseReference = FirebaseDatabase.getInstance().getReference("MarathonType");

        spinnerDatalist = new ArrayList<>();
        adapter = new ArrayAdapter<String>(Records.this, android.R.layout.simple_spinner_dropdown_item, spinnerDatalist);

        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);

        retrieveData();




//
//
//
//
//         //spinner = (Spinner)findViewById(R.id.spinner_dropdown);
//
//        //Creating an ArrayAdapter using the srting array and a default spinner layout;
//        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.counties, android.R.layout.simple_spinner_item);
//        ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
//        ArrayAdapter<CharSequence>adapter2=ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
//        ArrayAdapter<CharSequence>adapter3=ArrayAdapter.createFromResource(this, R.array.marathon_type, android.R.layout.simple_spinner_item);
//
//        //Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//
//        //Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
//        spinner1.setAdapter(adapter1);
//        spinner2.setAdapter(adapter2);
//        spinner3.setAdapter(adapter3);
//
//    }
//
//    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener{
//
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            Spinner spinner = (Spinner) findViewById(R.id.spinner_dropdown);
//            spinner.setOnItemSelectedListener(this);
//
//            Spinner spinner1 = (Spinner)findViewById(R.id.spinner_category);
//            spinner1.setOnItemSelectedListener(this);
//
//            Spinner spinner2 = (Spinner)findViewById(R.id.spinner_gender);
//            spinner2.setOnItemSelectedListener(this);
//
//            Spinner spinner3 = (Spinner)findViewById(R.id.spinner_gender);
//            spinner3.setOnItemSelectedListener(this);
//
//
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }
    }

    public void retrieveData(){
        listener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot item:dataSnapshot.getChildren()){

                    spinnerDatalist.add(item.getValue().toString());
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
