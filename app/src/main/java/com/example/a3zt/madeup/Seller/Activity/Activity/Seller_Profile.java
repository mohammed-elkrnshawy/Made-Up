package com.example.a3zt.madeup.Seller.Activity.Activity;

import android.support.annotation.Dimension;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;

import com.example.a3zt.madeup.R;

public class Seller_Profile extends AppCompatActivity {


    RatingBar ratingBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller__profile);
        ratingBar = findViewById(R.id.ProfileRate);

        ratingBar.setRating(3);

    }
}
