package com.example.a3zt.madeup.SharedPackage.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.a3zt.madeup.HandMaker.Activity.SellerHomeActivity;
import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.Remote.ApiUtlis;
import com.example.a3zt.madeup.Remote.UserService;
import com.example.a3zt.madeup.SharedPackage.Class.Response;

import retrofit2.Call;
import retrofit2.Callback;


public class RegisterActivity extends AppCompatActivity {

    private Dialog progressDialog;
    private EditText Edt_UserName , Edt_Email , Edt_PassWord , Edt_ConfPassword , Edt_Phone ;
    private Button Register ;
    private RelativeLayout Rel_Customer , Rel_HandMader ;
    private UserService userService;
    private RadioButton rbCustomer , rbHandMader ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shared_register);

        initView();
        CheckRoll();
        RegisterOnClick() ; 

    }

    private void CheckRoll() {

        rbHandMader.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbCustomer.setChecked(false);
                    Rel_HandMader.setBackground(getResources().getDrawable(R.drawable.shape_roll_pressed));
                    Rel_Customer.setBackground(getResources().getDrawable(R.drawable.shape_white));
                }
                else {
                    rbCustomer.setChecked(true);
                    Rel_Customer.setBackground(getResources().getDrawable(R.drawable.shape_roll_pressed));
                    Rel_HandMader.setBackground(getResources().getDrawable(R.drawable.shape_white));
                }
            }
        });


        rbCustomer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbHandMader.setChecked(false);
                    Rel_Customer.setBackground(getResources().getDrawable(R.drawable.shape_roll_pressed));
                    Rel_HandMader.setBackground(getResources().getDrawable(R.drawable.shape_white));
                }
                else {
                    rbHandMader.setChecked(true);
                    Rel_HandMader.setBackground(getResources().getDrawable(R.drawable.shape_roll_pressed));
                    Rel_Customer.setBackground(getResources().getDrawable(R.drawable.shape_white));
                }
            }
        });

        Rel_HandMader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbHandMader.setChecked(true);
                Rel_HandMader.setBackground(getResources().getDrawable(R.drawable.shape_roll_pressed));
                Rel_Customer.setBackground(getResources().getDrawable(R.drawable.shape_white));
            }
        });
        Rel_Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbCustomer.setChecked(true);
                Rel_Customer.setBackground(getResources().getDrawable(R.drawable.shape_roll_pressed));
                Rel_HandMader.setBackground(getResources().getDrawable(R.drawable.shape_white));
            }
        });

    }

    private void initView() {

        Edt_UserName = findViewById(R.id.Edt_UserName);
        Edt_Email = findViewById(R.id.Edt_Email);
        Edt_PassWord = findViewById(R.id.Edt_password);
        Edt_ConfPassword = findViewById(R.id.Edt_ConfPassword);
        Edt_Phone = findViewById(R.id.Edt_Phone);
        Register = findViewById(R.id.Btn_Register);
        Rel_Customer = findViewById(R.id.Rel_Customer2);
        Rel_HandMader = findViewById(R.id.Rel_HandMader);
        rbCustomer = findViewById(R.id.Radio_Customer);
        rbHandMader = findViewById(R.id.Radio_HandMader);


        userService = ApiUtlis.getUserService();
    }


    private void  RegisterOnClick(){
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }



    private void registerUser() {
        final String UserName = Edt_UserName.getText().toString().trim();
        final String Email = Edt_Email.getText().toString().trim();
        final String Password = Edt_PassWord.getText().toString().trim();
        final String ConfPassword = Edt_ConfPassword.getText().toString().trim();
        final String Phone = Edt_Phone.getText().toString().trim();

        if (TextUtils.isEmpty(UserName)){
           Edt_UserName.setError(getResources().getString(R.string.PleaseEnterYourName));
           Edt_UserName.requestFocus();
           return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
           Edt_Email.setError(getResources().getString(R.string.PleaseEnterYourEmail));
            Edt_Email.requestFocus();
           return;
        }

        if (TextUtils.isEmpty(Password)){
           Edt_PassWord.setError(getResources().getString(R.string.PleaseEnterYourPassword));
           Edt_PassWord.requestFocus();
           return;
        }

        if (TextUtils.isEmpty(ConfPassword)){
           Edt_ConfPassword.setError(getResources().getString(R.string.PleaseConfirmYourPassword));
           Edt_ConfPassword.requestFocus();
           return;
        }

        if (TextUtils.isEmpty(Phone)){
           Edt_Phone.setError(getResources().getString(R.string.PleaseConfirmYourPassword));
           Edt_Phone.requestFocus();
           return;
        }

        if(!Password.equals(ConfPassword))
        {
            Edt_ConfPassword.setError(getResources().getString(R.string.PasswordDontMatch));
            Edt_ConfPassword.requestFocus();
            return;
        }

        if(rbCustomer.isChecked()){
        callRegisterCustomer(UserName , Email , Password , Phone);
        }else if(rbHandMader.isChecked()){
            callRegisterHandMaker(UserName , Email , Password , Phone);
        }else {
            //Snackbar.make( RegisterActivity.this, "Choose Your roll" , Snackbar.LENGTH_LONG).show();
           Toast.makeText(this, "Choose Your roll", Toast.LENGTH_SHORT).show();
        }
    }



    private void callRegisterCustomer(String username , String email , String password , String phone){
        ShowWaiting();
        Call<Response> call=userService.RegisterCustomer(username,phone,email,password);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful())
                {
                    if(response.body().getValue())
                    {
                        progressDialog.dismiss();
                        //
                    }
                    else {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callRegisterHandMaker(String username , String email , String password , String phone){
        ShowWaiting();
        Call<Response> call=userService.RegisterSeller(username,phone,email,password);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful())
                {
                    if(response.body().getValue())
                    {
                        progressDialog.dismiss();
                        startActivity(new Intent(RegisterActivity.this, SellerHomeActivity.class));
                    }
                    else {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ShowWaiting()
    {
        progressDialog= new Dialog(this);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setContentView(R.layout.view_dialog);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setCancelable(true);

        progressDialog.show();
    }
}
