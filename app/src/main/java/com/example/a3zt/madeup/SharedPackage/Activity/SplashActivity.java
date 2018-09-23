package com.example.a3zt.madeup.SharedPackage.Activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.SharedPackage.Class.LanguageType;
import com.example.a3zt.madeup.SharedPackage.Class.PrefUtils;

import java.util.Locale;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shared_splash);


        new CountDownTimer(1000, 1000) {

            public void onTick(long millisUntilFinished) {
                /*LanguageType languageType=new LanguageType();
                languageType.languageType = "arabic";
                PrefUtils.setLanguage(languageType, SplashActivity.this);
                Log.e("Selected language", PrefUtils.getLanguage(SplashActivity.this).languageType);
                Configuration config = new Configuration();
                config.locale = new Locale("ar");
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());*/
            }

            public void onFinish() {
                Intent mainActivity = new Intent(SplashActivity.this, StartActivity.class);
                startActivity(mainActivity);
                finish();
            }
        }.start();



    }
}
