package com.auribises.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class EnquiryActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    CheckBox cbCpp, cbJava, cbPython;
    RadioButton rbMale, rbFemale;

    Spinner spCity;
    ArrayAdapter<String> adapter;


    EditText eTxtName;
    Button btnSubmit;

    void initViews(){
        cbCpp = findViewById(R.id.checkBoxCpp);
        cbJava = findViewById(R.id.checkBoxJava);
        cbPython = findViewById(R.id.checkBoxPython);

        rbMale = findViewById(R.id.radioButtonMale);
        rbFemale = findViewById(R.id.radioButtonFemale);

        spCity = findViewById(R.id.spinnerCity);

        eTxtName = findViewById(R.id.editTextName);

        btnSubmit = findViewById(R.id.buttonSubmit);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        adapter.add("--Select City--");
        adapter.add("Ludhiana");
        adapter.add("Delhi");
        adapter.add("Bengaluru");
        adapter.add("Chennai");
        adapter.add("Hyderabad");

        spCity.setAdapter(adapter);

        cbCpp.setOnCheckedChangeListener(this);
        cbJava.setOnCheckedChangeListener(this);
        cbPython.setOnCheckedChangeListener(this);
        rbMale.setOnCheckedChangeListener(this);
        rbFemale.setOnCheckedChangeListener(this);

        spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String city = adapter.getItem(i);
                Toast.makeText(EnquiryActivity.this,"You Selected "+city,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        initViews();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int id = compoundButton.getId();
        switch (id){
            case R.id.checkBoxCpp:

                if(b){
                    Toast.makeText(this,"You Checked CPP",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"You UnChecked CPP",Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.checkBoxJava:

                if(cbJava.isChecked()){
                    Toast.makeText(this,"You Checked Java",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"You UnChecked Java",Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.checkBoxPython:

                break;

            case R.id.radioButtonMale:
                Toast.makeText(this,"You Checked Male",Toast.LENGTH_LONG).show();
                break;

            case R.id.radioButtonFemale:
                Toast.makeText(this,"You Checked Female",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
