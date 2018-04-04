package com.auribises.myapp;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class BookFetcherService extends IntentService {

    RequestQueue requestQueue;
    StringRequest stringRequest;

    public BookFetcherService() {
        super("BookFetcherService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        //Toast.makeText(getApplicationContext(),"Service Started...",Toast.LENGTH_LONG).show();
        Log.i("BookFetcherService","onHandleIntent");

        requestQueue = Volley.newRequestQueue(this);

        stringRequest = new StringRequest(Request.Method.GET, "http://www.json-generator.com/api/json/get/chQLxhBjaW?indent=2",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("BookFetcherService","Response: "+response);
                        // Response Fetched should be shared back with the activity

                        Intent intent1 = new Intent("books.fetched");
                        intent1.putExtra("keyResponse",response);
                        sendBroadcast(intent1);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        requestQueue.add(stringRequest);

    }


}
