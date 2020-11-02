package com.example.athleticssports;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class AddData extends AppCompatActivity {

    Uri filePath;
    CountyDetails countyDetails;
    MarathonDetails marathonDetails;
    GenderDetails genderDetails;
    CategoryDetails categoryDetails;
    Button btnRegisterdetails;
    EditText countyName,Category,Gender,MarathonType;
    FirebaseStorage storage;
    StorageReference storageReference;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);


        Category  = (EditText)findViewById(R.id.county_name);
        btnRegisterdetails = (Button)findViewById(R.id.saveData);


        categoryDetails = new CategoryDetails();

        databaseReference = FirebaseDatabase.getInstance().getReference("Category");

        btnRegisterdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                categoryDetails.setCategoryType(Category.getText().toString().trim());


                databaseReference.push().setValue(categoryDetails);
                Toast.makeText(AddData.this,"Data inserted succesfully ",Toast.LENGTH_LONG).show();
            }
        });


    }



}
