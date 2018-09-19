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

import com.example.a3zt.madeup.HandMaker.HomeFragment.ProductsFragment;
import com.example.a3zt.madeup.HandMaker.HomeFragment.ProfileFragment;
import com.example.a3zt.madeup.HandMaker.HomeFragment.SalesFragment;
import com.example.a3zt.madeup.R;

public class SellerHomeActivity extends AppCompatActivity {

    private ActionBar toolbar;
    BottomNavigationView bnavigate ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saller_home);
        init();

        bnavigate = (BottomNavigationView) findViewById(R.id.navigation);
        bnavigate.setSelectedItemId(R.id.Nav_Products);
        loadFragment(new ProductsFragment());
        bnavigate.setOnNavigationItemSelectedListener(mItemSelected);

        toolbar.setTitle(R.string.products);

    }

    public void init(){
        toolbar = getSupportActionBar() ;
    }

private BottomNavigationView.OnNavigationItemSelectedListener mItemSelected = new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        Fragment fragment = null ;
        switch (item.getItemId()){

            case  R.id.Nav_Products :
                toolbar.setTitle(R.string.products);
                fragment = new ProductsFragment();
                loadFragment(fragment);
                return true;
            case  R.id.Nav_Profile :
                toolbar.setTitle(R.string.profile);
                fragment= new ProfileFragment();
                loadFragment(fragment);
                return true;
            case  R.id.Nav_Sales :
                toolbar.setTitle(R.string.sales);
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
