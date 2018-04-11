package com.auribises.myapp;

/**
 * Created by ishantkumar on 09/04/18.
 */

public class Feedback {

    public int id;
    public String name;
    public String phone;
    public String email;
    public double rating;

    Feedback(){

    }

    public Feedback(String name, String phone, String email, double rating) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.rating = rating;
    }
}
