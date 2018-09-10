package com.example.a3zt.madeup.HandMaker.Activity;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.a3zt.madeup.HandMaker.Adapter.ViewPagerAdapter;
import com.example.a3zt.madeup.R;

import java.util.ArrayList;
import java.util.List;


public class Activity_ProductDetails extends AppCompatActivity {

    ViewPager viewPager ;
    List<String> images  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saller_activity_product_details);


        images = new ArrayList<>();

        //TODo create for loop to get photo Urls from database to fill arraylist .

        viewPager = findViewById(R.id.photoViewer);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this , images);
        viewPager.setAdapter(adapter);


    }



}
