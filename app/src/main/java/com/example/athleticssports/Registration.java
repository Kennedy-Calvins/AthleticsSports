package com.example.athleticssports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {


    EditText emailtxt, passwordtxt;
    Button login;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();

        initializeUI();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewAthlete();
            }
        });


//        login = (Button)findViewById(R.id.get_started);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                openMainActvity();
//
//            }
//        });

    }

//    public void openMainActvity() {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }

    private void registerNewAthlete(){
        String email, passsword;

        email = emailtxt.getText().toString();
        passsword = passwordtxt.getText().toString();


        if(TextUtils.isEmpty(email)){

            Toast.makeText(getApplicationContext(), "Your email address is required", Toast.LENGTH_LONG).show();
            return;

        }

        if(TextUtils.isEmpty(passsword)){
            Toast.makeText(getApplicationContext(), "Your Password is required", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,passsword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

        if (task.isSuccessful()){
            Toast.makeText(getApplicationContext(), "Get started!", Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);

            Intent intent = new Intent(Registration.this, MainActivity.class);
            startActivity(intent);

        }

        else {

            Toast.makeText(Registration.this, "Registration failed!", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);

        }

            }
        });


    }

    private void initializeUI(){

        emailtxt = findViewById(R.id.text_Email);
        passwordtxt = findViewById(R.id.password);
        login = findViewById(R.id.get_started);
        progressBar = findViewById(R.id.progressBar);


    }


}


