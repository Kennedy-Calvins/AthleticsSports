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
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends AppCompatActivity {

    EditText emailtxt, passwordtxt;
    Button btnLogin, btnRegister;
    ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mAuth = FirebaseAuth.getInstance();

        initializeUI();

//        useremail = (EditText)findViewById(R.id.text_Email);
//        password = (EditText)findViewById(R.id.password);
//        progressBar = findViewById(R.id.progressBar);
//        btnLogin =(Button)findViewById(R.id.get_started);
//        btnRegister = (Button)findViewById(R.id.Get_Register);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginAthlete();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterAthlete();
            }
        });

    }

    public void onRegisterAthlete() {

        Intent intent = new Intent(WelcomeActivity.this, Registration.class);
        startActivity(intent);

    }


    private void onLoginAthlete() {

        String email, passsword;

        email = emailtxt.getText().toString();
        passsword = passwordtxt.getText().toString();

        if (TextUtils.isEmpty(email)) {

            Toast.makeText(getApplicationContext(), "Your email address is required!", Toast.LENGTH_LONG).show();
            return;

        }

        if (TextUtils.isEmpty(passsword)) {
            Toast.makeText(getApplicationContext(), "Your Password is required!", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, passsword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);

                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);

                } else {

                    Toast.makeText(WelcomeActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                }


            }
        });

    }

    private void initializeUI() {

        emailtxt = findViewById(R.id.text_Email);
        passwordtxt = findViewById(R.id.password);
        btnLogin = findViewById(R.id.get_started);
        btnRegister = findViewById(R.id.Get_Register);
        progressBar = findViewById(R.id.progressBar);
//
//
//    }


    }
}

