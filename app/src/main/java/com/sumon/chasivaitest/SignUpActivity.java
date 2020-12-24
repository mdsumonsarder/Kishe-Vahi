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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    //Variable Declear;
    private EditText signUpEmail,signUpPasswordText;
    private TextView signUpTextView;
    private Button signUpButton;
    private ProgressBar progressBar;

    //Firebase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        //To change ActionBar title
        getSupportActionBar().setTitle("নিবন্ধন করুন");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //Title change;
        this.setTitle("SignUp Activity");

        signUpEmail = findViewById(R.id.signupemailid);
        signUpPasswordText = findViewById(R.id.signupemailid);
        signUpTextView = findViewById(R.id.signuptextviewid);
        signUpButton = findViewById(R.id.signupbuttonid);
        progressBar = findViewById(R.id.progressberid);

        //Click Chack;
        signUpTextView.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }
    //Activity Chack;
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.signuptextviewid:

                Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
                startActivity(intent);
                break;
            case R.id.signupbuttonid:

                userRegister();
                break;
        }

    }


    //Registration Methood;
    private void userRegister() {

        String email = signUpEmail.getText().toString().trim();
        final String password = signUpPasswordText.getText().toString().trim();

        if (email.isEmpty()){

            signUpEmail.setError("Enter an email address");
            signUpEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {

            signUpEmail.setError("Enter a valid email address");
            signUpEmail.requestFocus();
            return;
        }

        if (password.isEmpty())
        {
            signUpPasswordText.setError("Enter an password address");
            signUpPasswordText.requestFocus();
            return;

        }

        if (password.length()<6)
        {

            signUpPasswordText.setError("Minimum length of a password should be 6");
            signUpPasswordText.requestFocus();
            return;
        }

        //Visibality On;
        progressBar.setVisibility(View.VISIBLE);


        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                //Visiblity Off;
                progressBar.setVisibility(View.GONE);


                if (task.isSuccessful()) {

                    finish();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                    //Clear;
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    Toast.makeText(SignUpActivity.this, "Register is successful", Toast.LENGTH_SHORT).show();

                } else {


                    if (task.getException() instanceof FirebaseAuthUserCollisionException)
                    {

                        Toast.makeText(SignUpActivity.this, "User is already registered", Toast.LENGTH_SHORT).show();
                    }

                    else {

                        Toast.makeText(SignUpActivity.this, "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            //Ends the activity
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
