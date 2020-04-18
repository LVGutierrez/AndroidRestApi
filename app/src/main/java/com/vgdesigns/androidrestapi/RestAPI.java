package com.vgdesigns.androidrestapi;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class RestAPI extends AsyncTask<ArrayList<String>, Void, String> {

    private MainActivity activity;
    private ProgressDialog progressDialog;
    private ArrayList<String> savedData = new ArrayList<>();

    RestAPI(MainActivity a) {
        activity = a;
        progressDialog = new ProgressDialog(a);
    }

    // ----------------------------

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // Start progress dialog
        progressDialog.setMessage("Loading...");
        progressDialog.show();

    }

    // ----------------------------

    @Override
    protected final String doInBackground(ArrayList<String>... arrayLists) {

        // API Manager

        try {

            String api = "add api url in this string";

            URL url = new URL(api);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            try {

                BufferedReader buffer = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line;

                while ((line = buffer.readLine()) != null) {
                    builder.append(line).append("\n");
                }

                buffer.close();
                return builder.toString();

            }

            finally {
                urlConnection.disconnect();
            }

        } catch(Exception error) {
            Log.e("Api Error", error.getMessage(), error);
            return null;
        }

    }

    // ----------------------------

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    // ----------------------------

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);

        if(data == null) {
            data = "There's an error.";
        }

        try {

            // Parse data
            JSONObject object = new JSONObject(data);

            // get json objects here

        } catch (JSONException e) {
            e.printStackTrace();
        }

        progressDialog.dismiss();

        // run UI components after data loads, ex. saveData = data.

    }

} // end RestAPI
