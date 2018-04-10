package com.auribises.myapp;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddFeedbackActivity extends AppCompatActivity {


    @BindView(R.id.editTextName)
    EditText eTxtName;

    @BindView(R.id.editTextPhone)
    EditText eTxtPhone;

    @BindView(R.id.editTextEmail)
    EditText eTxtEmail;

    @BindView(R.id.ratingBar)
    RatingBar ratingBar;

    Feedback feedback;

    RatingBar.OnRatingBarChangeListener ratingBarChangeListener = new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            feedback.rating = v;
        }
    };


    ContentResolver resolver; // to access ContentProvider

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feedback);

        ButterKnife.bind(this);

        feedback = new Feedback();

        ratingBar.setOnRatingBarChangeListener(ratingBarChangeListener);

        resolver = getContentResolver();

    }

    void addFeedback(){

        ContentValues values = new ContentValues();

        values.put(Util.COL_NAME,feedback.name);
        values.put(Util.COL_PHONE,feedback.phone);
        values.put(Util.COL_EMAIL,feedback.email);
        values.put(Util.COL_RATING,feedback.rating);

        Uri uri = resolver.insert(Util.URI,values);
        Toast.makeText(this,"Feedback Added "+uri.getLastPathSegment(),Toast.LENGTH_LONG).show();
    }



    public void clickHandler(View view){
        feedback.name = eTxtName.getText().toString();
        feedback.phone = eTxtPhone.getText().toString();
        feedback.email = eTxtEmail.getText().toString();

        addFeedback();
    }
}
