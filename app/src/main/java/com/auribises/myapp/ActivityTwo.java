package com.auribises.myapp;

import android.content.Intent;
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

        Intent rcv = getIntent();
        //String name = rcv.getStringExtra("keyName");
        //int age = rcv.getIntExtra("keyAge",0);

        /*Bundle rcvBun = rcv.getBundleExtra("keyBundle");

        String name = rcvBun.getString("keyName");
        int age = rcvBun.getInt("keyAge");*/

        Person person = (Person)rcv.getSerializableExtra("keyPerson");

        eTxtName.setText(person.name+" is "+person.age+" years old");

    }

    public void clickMe(View view){

        String name = eTxtName.getText().toString();
        String message = "Hello, "+name+" Its "+new Date();

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

        finish(); //Eqv of Pressing the back key
    }
}
