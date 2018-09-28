package com.example.a3zt.madeup.HandMaker.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.a3zt.madeup.HandMaker.HomeFragment.ProductsFragment;
import com.example.a3zt.madeup.HandMaker.HomeFragment.ProfileFragment;
import com.example.a3zt.madeup.HandMaker.HomeFragment.SalesFragment;
import com.example.a3zt.madeup.R;

public class SellerHomeActivity extends AppCompatActivity {


    BottomNavigationView bnavigate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_saller_home);

        InitComponent();




       /* toolbar = getSupportActionBar();
        toolbar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        toolbar.setTitle("Products");*/

    }

    public void InitComponent() {
        bnavigate = findViewById(R.id.navigation);
        bnavigate.setSelectedItemId(R.id.Nav_Products);
        loadFragment(new ProductsFragment());
        bnavigate.setOnNavigationItemSelectedListener(mItemSelected);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mItemSelected
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;
            switch (item.getItemId()) {

                case R.id.Nav_Products:
                    fragment = new ProductsFragment();
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

    public void buAddProduct(View view) {
       /* Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);*/
    }
}
