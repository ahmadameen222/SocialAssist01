package com.example.dell.socailassist01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

public class ProviderLoginActivity extends AppCompatActivity {

    CardView imageViewDriver, imageViewCarFix, imageViewPlumber, imageViewElectrician, imageViewTeleOp, imageViewInsuranceAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_login);

        imageViewDriver = (CardView)findViewById(R.id.imageViewDriver);
        imageViewCarFix = (CardView)findViewById(R.id.imageViewCarFix);
        imageViewPlumber = (CardView)findViewById(R.id.imageViewPlumber);
        imageViewElectrician = (CardView)findViewById(R.id.imageViewElectric);
        imageViewTeleOp = (CardView)findViewById(R.id.imageViewTelephone);
        imageViewInsuranceAgent = (CardView)findViewById(R.id.imageViewIns);

        imageViewDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProviderLoginActivity.this, UserLoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_left);

            }
        });

        imageViewCarFix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProviderLoginActivity.this, CarFixLoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_left);

            }
        });

        imageViewPlumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProviderLoginActivity.this, PlumberLoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_left);

            }
        });

        imageViewElectrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //    Intent intent = new Intent(ProviderLoginActivity.this, RegisterServiceProviderCarFixAcitivity.class);
                //    startActivity(intent);

            }
        });

        imageViewTeleOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //    Intent intent = new Intent(ProviderLoginActivity.this, RegisterServiceProviderCarFixAcitivity.class);
                //    startActivity(intent);

            }
        });

        imageViewInsuranceAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //    Intent intent = new Intent(ProviderLoginActivity.this, RegisterServiceProviderCarFixAcitivity.class);
                //    startActivity(intent);

            }
        });

    }
}
