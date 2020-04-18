package com.vgdesigns.androidrestapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Run the API task

        RestAPI runTask = new RestAPI(this);
        runTask.execute();

    } // end oncreate

} // end mainactivity
