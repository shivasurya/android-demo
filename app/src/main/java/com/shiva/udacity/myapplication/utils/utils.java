package com.shiva.udacity.myapplication.utils;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class utils {

    // define base api url
    // implement parsing interface
    // define generic error handler

    static String apikey = "REPLACE_ME";

    public static JSONObject getStops() throws JSONException
    {
        String url= "https://api.uwaterloo.ca/v2/transit/grt/stops.json?key="+apikey;

        String data = makeNetworkCalls(url);

        return new JSONObject(data);
    }

    public static String makeNetworkCalls(String urlAddress)
    {
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL(urlAddress);
            urlConnection = (HttpURLConnection) url.openConnection();

            int code = urlConnection.getResponseCode();
            if (code !=  200) {
                throw new IOException("Invalid response from server: " + code);
            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String line;
            String jsonString = "";
            while ((line = rd.readLine()) != null) {
                Log.i("data", line);
                jsonString = jsonString + line;
            }

            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return null;
    }
}
