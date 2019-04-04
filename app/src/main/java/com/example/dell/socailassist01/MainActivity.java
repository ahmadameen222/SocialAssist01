package com.example.dell.socailassist01;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    private LinearLayout register_layout, signin_layout, s_r_layout, drawer_layout;
    TextView drawer_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        register_layout = (LinearLayout)findViewById(R.id.register_layout);
        signin_layout = (LinearLayout)findViewById(R.id.signin_layout);
        drawer_layout = (LinearLayout)findViewById(R.id.drawer_layout);

        s_r_layout = (LinearLayout)findViewById(R.id.s_r_layout);

        drawer_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s_r_layout.setVisibility(View.VISIBLE);
            }
        });

        signin_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ProviderLoginActivity.class);
                startActivity(intent);

            }
        });

        register_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CustomerLoginActivity.class);
                startActivity(intent);

            }
        });


    }
}


