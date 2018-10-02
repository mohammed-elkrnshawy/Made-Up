package com.example.a3zt.madeup.HandMaker.Activity;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import com.example.a3zt.madeup.HandMaker.Adapter.ViewPagerAdapter;
import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.Image;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.Product;

import java.util.ArrayList;
import java.util.List;


public class Activity_ProductDetails extends AppCompatActivity {

    private TextView textProduct_Name,textProduct_Price;
    private Product product;
    private ViewPager viewPager ;
    private List<Image> images=new ArrayList<>()  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saller_product_details);

        InitComponent();

        getData();






    }

    private void InitComponent()
    {
        viewPager = findViewById(R.id.photoViewer);
        textProduct_Price=findViewById(R.id.txtPrice);
        textProduct_Name=findViewById(R.id.txtProductName);
    }

    private void getData()
    {
        Bundle  bundle=getIntent().getExtras();
        if (!bundle.isEmpty())
        {
            product=(Product) bundle.get("product");
            if (product!=null)
            {
                textProduct_Price.setText(product.getPrice());
                textProduct_Name.setText(product.getName());
                images=product.getImages();
                ViewPagerAdapter adapter = new ViewPagerAdapter(this , images);
                viewPager.setAdapter(adapter);
            }
        }
    }
}
