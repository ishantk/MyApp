package com.auribises.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class ActivityTwo extends AppCompatActivity {

    EditText eTxtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        eTxtName = findViewById(R.id.editTextName);

    }

    public void clickMe(View view){

        String name = eTxtName.getText().toString();
        String message = "Hello, "+name+" Its "+new Date();

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

        finish(); //Eqv of Pressing the back key
    }
}
