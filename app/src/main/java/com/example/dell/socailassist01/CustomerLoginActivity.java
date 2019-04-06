package com.example.dell.socailassist01;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerLoginActivity extends AppCompatActivity {


    private EditText mEmail, mPassword;
    private Button mLogin, mRegistration;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    private ProgressDialog nDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);


            mAuth = FirebaseAuth.getInstance();

            firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if(user!=null){
                        Intent intent = new Intent(CustomerLoginActivity.this, CustomerMapActivity.class);
                        startActivity(intent);

                        overridePendingTransition(R.anim.fade_in_animation, R.anim.fade_out_animation);
                        finish();
                        return;
                    }
                }
            };

            mEmail = (EditText) findViewById(R.id.email);
            mPassword = (EditText) findViewById(R.id.password);

            mLogin = (Button) findViewById(R.id.login);
            mRegistration = (Button) findViewById(R.id.registration);

            mRegistration.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String email = mEmail.getText().toString();
                    final String password = mPassword.getText().toString();

                    nDialog = new ProgressDialog(CustomerLoginActivity.this);
                    nDialog.setMessage("Loading..");
                    nDialog.setTitle("Sending Your Data...");
                    nDialog.setIndeterminate(false);
                    nDialog.setCancelable(true);
                    nDialog.show();

                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(CustomerLoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(CustomerLoginActivity.this, "Sign up Error", Toast.LENGTH_SHORT).show();
                                nDialog.dismiss();
                            }else{
                                nDialog.dismiss();
                                String user_id = mAuth.getCurrentUser().getUid();
                                DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child("Customers").child(user_id);
                                current_user_db.setValue(true);
                            }
                        }
                    });
                }
            });

            mLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String email = mEmail.getText().toString();
                    final String password = mPassword.getText().toString();

                    nDialog = new ProgressDialog(CustomerLoginActivity.this);
                    nDialog.setMessage("Loading..");
                    nDialog.setTitle("Fetching Your Data...");
                    nDialog.setIndeterminate(false);
                    nDialog.setCancelable(true);
                    nDialog.show();

                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(CustomerLoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(CustomerLoginActivity.this, "Sign in Error!", Toast.LENGTH_SHORT).show();
                                nDialog.dismiss();
                            }
                        }
                    });

                }
            });
        }


        @Override
        protected void onStart() {
            super.onStart();
            mAuth.addAuthStateListener(firebaseAuthListener);
        }
        @Override
        protected void onStop() {
            super.onStop();
            mAuth.removeAuthStateListener(firebaseAuthListener);
        }

    }

