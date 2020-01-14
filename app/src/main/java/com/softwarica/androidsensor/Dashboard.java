package com.softwarica.androidsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
Button btnacc,btnallsens,btngryoscope;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnacc=findViewById(R.id.btnaccelerometer);
        btnallsens=findViewById(R.id.btnshow);
        btngryoscope=findViewById(R.id.btngyroscope);
        btnacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this, Accelerometer.class);
                startActivity(intent);
            }


        });
        btnallsens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btngryoscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this, Sensorgyro.class);
                startActivity(intent);
            }
        });


    }
}
