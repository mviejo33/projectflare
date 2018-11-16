package com.eclairios.signedqrcodeapp;

import android.app.Application;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

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

//    public  LatLng getLocation()
//    {
//        // Get the location manager
//        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        Criteria criteria = new Criteria();
//        String bestProvider = locationManager.getBestProvider(criteria, false);
//        Location location = locationManager.getLastKnownLocation(bestProvider);
//        Double lat,lon;
//        try {
//            lat = location.getLatitude ();
//            lon = location.getLongitude ();
//
//            return new LatLng(lat, lon);
//        }
//        catch (NullPointerException e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//    static String BaseUrl="https://gaslicuadosabinas.com/";
//    static String url=BaseUrl+"android/";
//    static String urlInsert=BaseUrl+"android/qr_code_api.php";
//    static String urlSiafuRest=BaseUrl+"api.php/";
//    static String BaseUrl="http://192.168.15.76/";
//    static String url=BaseUrl+"qr_code/";
//    static String urlInsert=BaseUrl+"qr_code/qr_code_api.php";

}
