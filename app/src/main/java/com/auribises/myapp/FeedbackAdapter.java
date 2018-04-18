package com.auribises.myapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishantkumar on 11/04/18.
 */

public class FeedbackAdapter extends ArrayAdapter<Feedback>{

    Context context;
    int resource;
    ArrayList<Feedback> objects;

    public FeedbackAdapter(Context context, int resource, ArrayList<Feedback> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(resource,parent,false);

        TextView txtName = view.findViewById(R.id.textViewName);
        TextView txtEmail = view.findViewById(R.id.textViewEmail);

        Feedback feedback = objects.get(position);
        txtName.setText(feedback.name);
        txtEmail.setText(feedback.email);

        return view;
    }
}
