package com.example.dell.socailassist01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProviderLoginActivity extends AppCompatActivity {

    ImageView imageViewDriver, imageViewCarFix, imageViewPlumber, imageViewElectrician, imageViewTeleOp, imageViewInsuranceAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_login);

        imageViewDriver = (ImageView)findViewById(R.id.imageViewDriver);
        imageViewCarFix = (ImageView)findViewById(R.id.imageViewCarFix);
        imageViewPlumber = (ImageView)findViewById(R.id.imageViewPlumber);
        imageViewElectrician = (ImageView)findViewById(R.id.imageViewElectrician);
        imageViewTeleOp = (ImageView)findViewById(R.id.imageViewTeleOp);
        imageViewInsuranceAgent = (ImageView)findViewById(R.id.imageViewInsuranceAgent);

        imageViewDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProviderLoginActivity.this, DriverLoginActivity.class);
                startActivity(intent);

            }
        });

        imageViewCarFix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //    Intent intent = new Intent(ProviderLoginActivity.this, RegisterServiceProviderCarFixAcitivity.class);
            //    startActivity(intent);

            }
        });

    }
}
