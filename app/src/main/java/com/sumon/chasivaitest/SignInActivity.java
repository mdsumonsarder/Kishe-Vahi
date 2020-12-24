package com.sumon.chasivaitest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity  {

    //Variable Declare;
    private EditText signInEmailText,signInPasswordText;
    private Button signInButton;
    private TextView signUpTextView;
    private ProgressBar progressBar;

    //Firebase variable;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
        //To change ActionBar title;
        getSupportActionBar().setTitle("প্রবেশ করুন");



        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        signInEmailText = findViewById(R.id.signinemailid);
        signInPasswordText = findViewById(R.id.signinpasswordid);
        signUpTextView = findViewById(R.id.signuptextviewid);
        signInButton = findViewById(R.id.signinbuttonid);
        progressBar = findViewById(R.id.progressberid);

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });

        FirebaseUser user=mAuth.getCurrentUser();
        if(user!=null)
        {
            finish();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signInEmailText.getText().toString().isEmpty() || signInPasswordText.getText().toString().isEmpty())
                {
                    Toast.makeText(SignInActivity.this, "Fill the field", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    validate(signInEmailText.getText().toString(),signInPasswordText.getText().toString());
                }
            }
        });

    }

    private void validate(String email,String password)
    {

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(SignInActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
