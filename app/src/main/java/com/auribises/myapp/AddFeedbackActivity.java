package com.auribises.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feedback);

        ButterKnife.bind(this);

        feedback = new Feedback();

        ratingBar.setOnRatingBarChangeListener(ratingBarChangeListener);

    }

    public void clickHandler(View view){
        feedback.name = eTxtName.getText().toString();
        feedback.phone = eTxtPhone.getText().toString();
        feedback.email = eTxtEmail.getText().toString();
    }
}
