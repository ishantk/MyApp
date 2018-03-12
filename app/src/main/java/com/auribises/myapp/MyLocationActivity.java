package com.auribises.myapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyLocationActivity extends AppCompatActivity implements View.OnClickListener, LocationListener {

    /*
        Cell Tower Technology     | CTT
        Global Positioning System | GPS
     */

    TextView txtLocation;
    Button btnFetch;

    LocationManager locationManager;

    void initViews() {
        txtLocation = findViewById(R.id.textViewLocation);
        btnFetch = findViewById(R.id.buttonFetch);
        btnFetch.setOnClickListener(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);
        initViews();
    }

    @Override
    public void onClick(View view) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Please Grant Permissions from Settings",Toast.LENGTH_LONG).show();
        }else {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 60, 10, this);
        }


    }

    @Override
    public void onLocationChanged(Location location) {

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        locationManager.removeUpdates(this);



        // Reverse Geocoding
        StringBuilder builder = new StringBuilder();
        try{

            Geocoder geocoder = new Geocoder(this);
            List<Address> adrsList = geocoder.getFromLocation(latitude,longitude,3);

            if(adrsList!=null && adrsList.size()>0){
                Address address = adrsList.get(0);

                //String city = address.getAdminArea();

                for(int i=0;i<=address.getMaxAddressLineIndex();i++){
                    builder.append(address.getAddressLine(i)+"\n");
                }

            }

            txtLocation.setText("Location: "+latitude+" : "+longitude+"\n"+builder.toString());

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
