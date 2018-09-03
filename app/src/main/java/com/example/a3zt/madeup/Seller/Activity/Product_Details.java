package com.example.a3zt.madeup.Seller.Activity;


import android.animation.ObjectAnimator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;


import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.Seller.Activity.Adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class Product_Details extends AppCompatActivity {

    ViewPager viewPager ;
    List<String> images  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__details);


        images = new ArrayList<>();

        //TODo create for loop to get photo Urls from database to fill arraylist .

        viewPager = findViewById(R.id.photoViewer);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this , images);
        viewPager.setAdapter(adapter);


    }



}
