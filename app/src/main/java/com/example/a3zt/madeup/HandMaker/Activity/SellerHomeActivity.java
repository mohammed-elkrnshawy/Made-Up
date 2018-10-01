package com.example.a3zt.madeup.HandMaker.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.a3zt.madeup.HandMaker.HomeFragment.ProductsFragment;
import com.example.a3zt.madeup.HandMaker.HomeFragment.ProfileFragment;
import com.example.a3zt.madeup.HandMaker.HomeFragment.SalesFragment;
import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.SharedPackage.Activity.LoginActivity;
import com.example.a3zt.madeup.SharedPackage.Class.DataUser;

public class SellerHomeActivity extends AppCompatActivity {


    private FloatingActionButton fab;
    private BottomNavigationView bnavigate;
    private DataUser user;
    private String UserID,UserToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_saller_home);

        InitComponent();

        SharedPreferencesRead();

        loadFragment(new ProductsFragment(UserID,UserToken));

        getUserData();

        fabClick();


    }

    public void InitComponent() {
        bnavigate = findViewById(R.id.navigation);
        bnavigate.setSelectedItemId(R.id.Nav_Products);
        bnavigate.setOnNavigationItemSelectedListener(mItemSelected);
        fab=findViewById(R.id.addProduct);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mItemSelected
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;
            switch (item.getItemId()) {

                case R.id.Nav_Products:
                    fragment = new ProductsFragment(UserID,UserToken);
                    loadFragment(fragment);
                    return true;
                case R.id.Nav_Profile:
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.Nav_Sales:
                    fragment = new SalesFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void SharedPreferencesRead()
    {
        SharedPreferences prefs = getSharedPreferences(getApplication().getPackageName(), MODE_PRIVATE);
        boolean isLoggin = prefs.getBoolean("isLogin", false);
        if (isLoggin) {
            UserID=prefs.getString("id", null);
            UserToken=prefs.getString("token", null);
        }
        else {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

    }

    private void getUserData()
    {

    }

    private void fabClick()
    {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddProduct=new Intent(SellerHomeActivity.this,Activity_AddProduct.class);
                intentAddProduct.putExtra("user",user);
                startActivity(intentAddProduct);
            }
        });
    }
}
