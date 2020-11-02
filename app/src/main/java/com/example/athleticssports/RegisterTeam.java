package com.example.athleticssports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class RegisterTeam extends AppCompatActivity {


    ImageView imageView;

    Uri filePath;

    final int PICK_IMAGE_REQUEST = 71;

    //firebase varibales declaration
    FirebaseStorage storage;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    TeamDetails teamDetails;
    EditText Tname, ManagerName;
    Button  buttonSaveTeam;
    long teamID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_team);

        databaseReference = FirebaseDatabase.getInstance().getReference("TeamDetails");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    teamID = (dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Tname = (EditText)findViewById(R.id.team_name);
        ManagerName = (EditText)findViewById(R.id.team_manager);
        buttonSaveTeam = (Button)findViewById(R.id.save_team);

        teamDetails = new TeamDetails();

        buttonSaveTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamDetails.setTeamName(Tname.getText().toString().trim());
                teamDetails.setTeamManager(ManagerName.getText().toString().trim());

                databaseReference.child(String.valueOf(teamID+1)).setValue(teamDetails);

                databaseReference.push().setValue(teamDetails);
                Toast.makeText(RegisterTeam.this,"Team registered succesfully ",Toast.LENGTH_LONG).show();


            }
        });



                //addTeam();

//                teamDetails.setTeamName(name.getText().toString().trim());
//                teamDetails.setTeamManager(ManagerName.getText().toString().trim());
//
//                databaseReference.push().setValue(teamDetails);
//                Toast.makeText(RegisterTeam.this,"Team Registered Succesfully!",Toast.LENGTH_LONG).show();



        //Firebase Init
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference("TeamDetails");




        imageView = (ImageView)findViewById(R.id.athlete_photo);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
                uploadImage();
            }
        });



    }

    public void chooseImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Team photo"),PICK_IMAGE_REQUEST);

    }

    public void uploadImage(){

        String logoID;
        logoID = "images/"+ UUID.randomUUID().toString();

        if (filePath != null){

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading Team Photo...");
            progressDialog.show();

            StorageReference ref = storageReference.child(logoID);
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(RegisterTeam.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterTeam.this, "Failed!Please try again"+ e.getMessage(), Toast.LENGTH_SHORT).show();
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
}
