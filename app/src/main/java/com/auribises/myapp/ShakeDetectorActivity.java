package com.auribises.myapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShakeDetectorActivity extends AppCompatActivity implements View.OnClickListener,SensorEventListener{

    TextView txtTitle;
    Button btnShake;

    SensorManager sensorManager;
    Sensor sensor;

    double latitude,longitude;
    String address;
    String phone = "+91 99155 71177";

    void initViews(){
        txtTitle = findViewById(R.id.textViewTitle);
        btnShake = findViewById(R.id.buttonShake);
        btnShake.setOnClickListener(this);


        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake_detector);
        initViews();
    }

    @Override
    public void onClick(View view) {

        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float[] values = sensorEvent.values; // output of sensor

        float x = values[0];
        float y = values[1];
        float z = values[2];

        float cal = ((x*x)+(y*y)+(z*z))/(SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);

        if(cal > 3){
            txtTitle.setText("Shake Detected at | "+x+":"+y+":"+z);

            sensorManager.unregisterListener(this);

            // Fetch the Location
            // Request LocationManager here

        }else{
            txtTitle.setText("Points | "+x+":"+y+":"+z);
        }

    }

    void sendMessage(){
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phone,null,"I am in Emergency. Pleas help me. My Details are: "+address+"\nLocation: "+latitude+":"+longitude,null,null);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
