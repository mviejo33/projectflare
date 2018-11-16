package com.eclairios.signedqrcodeapp;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class Constants extends Application{

    private Hashtable<String, String> contacts
            = new Hashtable<String, String>();

    public ArrayList<String[]> getContacts() {
        Iterator it = contacts.entrySet().iterator();
        ArrayList<String[]> contactsArray = new ArrayList<String[]>();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String number = (String)pair.getKey();
            String message = (String)pair.getValue();
            String[] contactPair = new String[]{number, message};
            contactsArray.add(contactPair);
            it.remove(); // avoids a ConcurrentModificationException
        }
        return contactsArray;
    }

    public void setContact(String phone, String message) {
        contacts.put(phone, message);
    }

    public void getLocation() {
        Log.d("aaaa", "wwww");

        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) == PackageManager.PERMISSION_GRANTED ) {
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            // get the last know location from your location manager.
            Location location= locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            // now get the lat/lon from the location and do something with it.
            Log.d("11111", (String)(location.getLatitude() + ""));

        }



//            nowDoSomethingWith(location.getLatitude(), location.getLongitude());


    }
//    LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
//    Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//
//    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
//    double longitude = location.getLongitude();
//    double latitude = location.getLatitude();


    static String BaseUrl="https://gaslicuadosabinas.com/";
    static String url=BaseUrl+"android/";
    static String urlInsert=BaseUrl+"android/qr_code_api.php";
    static String urlSiafuRest=BaseUrl+"api.php/";
//    static String BaseUrl="http://192.168.15.76/";
//    static String url=BaseUrl+"qr_code/";
//    static String urlInsert=BaseUrl+"qr_code/qr_code_api.php";

}
