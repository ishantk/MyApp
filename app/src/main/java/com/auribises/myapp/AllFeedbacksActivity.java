package com.auribises.myapp;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllFeedbacksActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ContentResolver resolver;
    ArrayList<Feedback> feedbacks;

    ListView listView;
    FeedbackAdapter feedbackAdapter;

    Feedback feedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_feedbacks);

        resolver = getContentResolver();
        feedbacks = new ArrayList<>();

        listView = findViewById(R.id.listView);

        retrieveFeedbacks();
    }

    void retrieveFeedbacks(){

        String[] projection = {Util.COL_ID,Util.COL_NAME,Util.COL_PHONE,Util.COL_EMAIL,Util.COL_RATING};
        Cursor cursor = resolver.query(Util.URI,projection,null,null,null);


        while(cursor.moveToNext()){

            Feedback feedback = new Feedback();

            feedback.id = cursor.getInt(cursor.getColumnIndex(Util.COL_ID));
            feedback.name = cursor.getString(cursor.getColumnIndex(Util.COL_NAME));
            feedback.phone = cursor.getString(cursor.getColumnIndex(Util.COL_PHONE));
            feedback.email = cursor.getString(cursor.getColumnIndex(Util.COL_EMAIL));
            feedback.rating = cursor.getDouble(cursor.getColumnIndex(Util.COL_RATING));

            feedbacks.add(feedback);

            //Toast.makeText(this,"Feedback Name: "+feedback.name,Toast.LENGTH_LONG).show();
        }

        cursor.close();

        feedbackAdapter = new FeedbackAdapter(this,R.layout.list_item,feedbacks);
        listView.setAdapter(feedbackAdapter);
        listView.setOnItemClickListener(this);
    }

    void showOptions(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String[] items = {"View","Update","Delete"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        feedback = feedbacks.get(i);
        Toast.makeText(this,"You Selected: "+feedback.name,Toast.LENGTH_LONG).show();
        showOptions();
    }
}
