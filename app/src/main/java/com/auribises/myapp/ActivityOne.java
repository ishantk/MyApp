package com.auribises.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        //System.out.println("--ActivityOne onCreate--");
        Log.i("ActivityOne","--onCreate--");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //System.out.println("--ActivityOne onStart--");
        Log.i("ActivityOne","--onStart--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //System.out.println("--ActivityOne onResume--");
        Log.i("ActivityOne","--onResume--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //System.out.println("--ActivityOne onPause--");
        Log.i("ActivityOne","--onPause--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //System.out.println("--ActivityOne onStop--");
        Log.i("ActivityOne","--onStop--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //System.out.println("--ActivityOne onDestroy--");
        Log.i("ActivityOne","--onDestroy--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //System.out.println("--ActivityOne onRestart--");
        Log.i("ActivityOne","--onRestart--");
    }

    public void clickHandler(View view){

        Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);
        startActivity(intent);

    }
}
