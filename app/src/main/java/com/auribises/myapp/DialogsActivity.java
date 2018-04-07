package com.auribises.myapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DialogsActivity extends AppCompatActivity {


    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener dateSetListener;

    TimePickerDialog timePickerDialog;
    TimePickerDialog.OnTimeSetListener timeSetListener;

    void showTimePicker(){

        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                String time = i+":"+i1;
                Toast.makeText(DialogsActivity.this,"You Selected: "+time,Toast.LENGTH_LONG).show();
            }
        };

        Calendar calendar = Calendar.getInstance();
        int hh = calendar.get(Calendar.HOUR);
        int mm = calendar.get(Calendar.MINUTE);

        timePickerDialog = new TimePickerDialog(this,timeSetListener,hh,mm,true);
        timePickerDialog.show();
    }

    void showDatePicker(){
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String date = i+"/"+(i1+1)+"/"+i2;
                Toast.makeText(DialogsActivity.this,"You Selected: "+date,Toast.LENGTH_LONG).show();
            }
        };

        Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this,dateSetListener,yy,mm,dd);
        datePickerDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
    }

    void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title");
        builder.setMessage("This is Message");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    void showAlertDialogWithItems(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String[] items = {"View","Update", "Delete", "Cancel"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:

                        break;

                    case 3:
                        finish();
                        break;
                }
            }
        });

        AlertDialog dialog = builder.create();
        //dialog.setCancelable(false);
        dialog.show();
    }

    void showProgressDialog(){
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please Wait...");
        //dialog.setCancelable(false);
        dialog.show();

        //dialog.dismiss();
    }

    Button btnSubmit;

    void showCustomDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_dialog);

        btnSubmit = dialog.findViewById(R.id.buttonSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        dialog.show();
    }

    public void clickHandler(View view){
        //showAlertDialog();
        //showAlertDialogWithItems();
        //showProgressDialog();
        //showCustomDialog();
        //showDatePicker();
        showTimePicker();
    }
}
