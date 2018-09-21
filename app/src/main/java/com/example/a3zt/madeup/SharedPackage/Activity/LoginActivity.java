package com.example.a3zt.madeup.SharedPackage.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.a3zt.madeup.HandMaker.Activity.SellerHomeActivity;
import com.example.a3zt.madeup.R;

public class LoginActivity extends AppCompatActivity {

    private Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shared_login);
        InitComponent();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SellerHomeActivity.class));
            }
        });


    }
    private void InitComponent()
    {
        Login=findViewById(R.id.bt_login);
    }
}
