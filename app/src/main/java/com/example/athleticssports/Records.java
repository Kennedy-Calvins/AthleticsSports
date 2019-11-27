package com.example.athleticssports;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class Records extends AppCompatActivity {

    //Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

//        Spinner spinner = (Spinner) findViewById(R.id.spinner_dropdown);
//        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_category);
//        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_gender);
//        Spinner spinner3 = (Spinner)findViewById(R.id.spinner_marathon);
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
}
