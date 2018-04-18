package com.auribises.myapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ishantkumar on 18/04/18.
 */

public class FeedbackRecyclerAdapter extends RecyclerView.Adapter<FeedbackRecyclerAdapter.ViewHolder>{

    Context context;
    int resource;
    ArrayList<Feedback> objects;

    public FeedbackRecyclerAdapter(Context context, int resource, ArrayList<Feedback> objects) {
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(resource,parent,false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Feedback feedback = objects.get(position);
        holder.txtName.setText(feedback.name);
        holder.txtEmail.setText(feedback.email);

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        TextView txtEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.textViewName);
            txtEmail = itemView.findViewById(R.id.textViewEmail);
        }
    }

}
