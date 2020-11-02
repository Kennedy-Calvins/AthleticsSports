package com.example.athleticssports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class RegisterAthlete extends AppCompatActivity {

    ImageView imageView;

    Uri filePath;

    final int PICK_IMAGE_REQUEST = 71;

    //firebase varibales declaration
    FirebaseStorage storage;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    ValueEventListener listener;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> spinnerDatalist;
    AthleteDetails athleteDetails;
    Spinner spinner;
    EditText name, PhoneNo;
    String textName = "";
    Button buttonSaveAthlete;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_athlete);

        name = (EditText)findViewById(R.id.athlete_name);
        PhoneNo = (EditText)findViewById(R.id.athlete_phone_no);
        spinner = (Spinner)findViewById(R.id.spinner_team_name);
        buttonSaveAthlete = (Button)findViewById(R.id.save_athlete);

        athleteDetails = new AthleteDetails();



        databaseReference = FirebaseDatabase.getInstance().getReference("AthleteDetails");


        buttonSaveAthlete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               addAthlete();

                Toast.makeText(RegisterAthlete.this,"Athlete registered succesfully ",Toast.LENGTH_LONG).show();

                storage = FirebaseStorage.getInstance();
                storageReference = storage.getReference("Athlete Photo");

                uploadImage();


            }
        });

        //Firebase Init
//        storage = FirebaseStorage.getInstance();
//        storageReference = storage.getReference("Athlete Photo");




        imageView = (ImageView)findViewById(R.id.athlete_photo);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();

            }
        });
    }

//    public void addAthlete() {
//
//        String athleteName = name.getText().toString();
//        Long athletePhone = Long.parseLong(PhoneNo.getText().toString().trim());
//
//        if (!TextUtils.isEmpty(athleteName) && !TextUtils.isEmpty(athletePhone)) {
//
//            String id = databaseReference.push().getKey();
//
//            AthleteDetails athleteDetails = new AthleteDetails(id,athleteName,athletePhone);
//
//            databaseReference.child(id).setValue(athleteDetails);
//            name.setText("");
//            PhoneNo.setText("");
//
//
//        } else {
//            Toast.makeText(RegisterAthlete.this, "Please Enter the required details", Toast.LENGTH_LONG).show();
//        }
//
//    }

    public void chooseImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Athlete Photo"),PICK_IMAGE_REQUEST);

    }

    public void uploadImage(){

        String imageid;
        imageid = "images/"+ UUID.randomUUID().toString();

        Long athletePhone = Long.parseLong(PhoneNo.getText().toString().trim());


        athleteDetails.setAthleteName(name.getText().toString().trim());
        athleteDetails.setAthletePhoneNo(athletePhone);
        athleteDetails.setImageid(imageid);


        databaseReference.push().setValue(athleteDetails);


        if (filePath != null){

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading Athlete Photo...");
            progressDialog.show();

            StorageReference ref = storageReference.child(imageid);
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(RegisterAthlete.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterAthlete.this, "Failed!Please try again"+ e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {

                    double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    progressDialog.setMessage("Uploaded"+(int)progress+"%");

                }
            });
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
            && data !=null && data.getData() !=null)
        {
            filePath = data.getData();
            try {

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);

                }
            catch (IOException e){

                e.printStackTrace();

            }

        }
    }


//    public void SaveTheAthlete(View view) {
//
//        textName = name.getText().toString().trim();
//        databaseReference.push().setValue(textName).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                name.setText("");
//                Toast.makeText(RegisterAthlete.this, "", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//    }
}
