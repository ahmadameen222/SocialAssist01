package com.example.dell.socailassist01;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
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
    private TextView drawer_tv;
    private ImageView customer_img, taxi_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        register_layout = (LinearLayout)findViewById(R.id.register_layout);
        signin_layout = (LinearLayout)findViewById(R.id.signin_layout);
        drawer_layout = (LinearLayout)findViewById(R.id.drawer_layout);

        customer_img = (ImageView)findViewById(R.id.customer_img);
        taxi_img = (ImageView)findViewById(R.id.taxi_img);


        s_r_layout = (LinearLayout)findViewById(R.id.s_r_layout);

        drawer_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(s_r_layout.getVisibility() == View.VISIBLE)
                {
                    s_r_layout.setVisibility(View.GONE);
                }
                else
                {
                    s_r_layout.setVisibility(View.VISIBLE);
                }

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

        customer_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CustomerLoginActivity.class);
                startActivity(intent);

            }
        });

        taxi_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ProviderLoginActivity.class);
                startActivity(intent);

            }
        });

    }

}


