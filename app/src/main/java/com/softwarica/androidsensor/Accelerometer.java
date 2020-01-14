package com.softwarica.androidsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Accelerometer extends AppCompatActivity {
TextView tvShowAxis;
SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        tvShowAxis=findViewById(R.id.tvShowAxis);
        //Used for recieving notifications from the SensorManager when dynamic sensors
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sel=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] values = event.values;
                String xAxis = "x :" + values[0];
                String yAxis = "y :" + values[1];
                String zAxis = "z :" + values[2];
                tvShowAxis.setText(xAxis + "" + yAxis + "" + zAxis);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        if (sensor!=null){
            sensorManager.registerListener(sel,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Toast.makeText(this, "No sensor Found", Toast.LENGTH_SHORT).show();
        }

        }
    }

