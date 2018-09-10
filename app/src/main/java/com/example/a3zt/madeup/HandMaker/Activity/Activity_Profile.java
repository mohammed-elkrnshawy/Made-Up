package com.example.a3zt.madeup.HandMaker.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;

import com.example.a3zt.madeup.R;

public class Activity_Profile extends AppCompatActivity {


    RatingBar ratingBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saller_activity_profile);
        ratingBar = findViewById(R.id.ProfileRate);

        ratingBar.setRating(3);

    }
}
