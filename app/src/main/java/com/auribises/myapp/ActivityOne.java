package com.auribises.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityOne extends AppCompatActivity {

    TextView txt;
    EditText eTxt;

    void initViews(){
        txt = findViewById(R.id.textView);
        eTxt = findViewById(R.id.editText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        //System.out.println("--ActivityOne onCreate--");
        Log.i("ActivityOne","--onCreate--");

        initViews();
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

        String name = eTxt.getText().toString();
        //txt.setText("Welcome, "+name);


        // Forward Passing
        Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);

        //intent.putExtra("keyName",name);
        //intent.putExtra("keyAge",20);

        /*Bundle bundle = new Bundle();
        bundle.putString("keyName",name);
        bundle.putInt("keyAge",20);

        intent.putExtra("keyBundle",bundle);*/

        Person pRef = new Person();
        pRef.name = name;
        pRef.age = 29;

        intent.putExtra("keyPerson",pRef);

        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        // Explicit Menu
        /*menu.add(1,101,2,"All Songs");
        menu.add(1,102,1,"Favorites");
        menu.add(1,103,4,"Artists");
        menu.add(2,104,5,"Recently Played");
        menu.add(2,105,3,"Album");*/

        // Implicit Menu
        getMenuInflater().inflate(R.menu.activityone_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        int gid = item.getGroupId();

        Toast.makeText(this,"Item and Group ID's "+id+" - "+gid,Toast.LENGTH_LONG).show();

        switch (id){

            case 101:

                // Explicit Intent
                //Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);

                // Implicit Intent
                Intent intent = new Intent("com.auribises.myapp.ActivityTwo");
                startActivity(intent);


                break;

            case 102:

                break;

            case 103:

                break;

            case R.id.add:
                Intent intent1 = new Intent("com.auribises.myapp.ActivityTwo");
                startActivity(intent1);
                break;

            case R.id.delete:

                break;
        }

        return super.onOptionsItemSelected(item);

    }
}
