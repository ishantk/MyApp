package com.auribises.myapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyFragmentsActivity extends AppCompatActivity {

    UpperFragment upperFragment;
    LowerFragment lowerFragment;

    FragmentManager fragmentManager;

    void initViews(){
        upperFragment = new UpperFragment();
        lowerFragment = new LowerFragment();

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.upperFrame,upperFragment).commit();
        fragmentManager.beginTransaction().add(R.id.lowerFrame,lowerFragment).commit();
        //fragmentManager.beginTransaction().replace(R.id.lowerFrame,otherFragment).commit();
        //fragmentManager.beginTransaction().remove(lowerFragment).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragments);
        initViews();
    }
}
