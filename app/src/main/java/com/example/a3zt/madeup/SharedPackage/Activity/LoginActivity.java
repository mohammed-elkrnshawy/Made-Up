package com.example.a3zt.madeup.SharedPackage.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a3zt.madeup.HandMaker.Activity.SellerHomeActivity;
import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.Remote.ApiUtlis;
import com.example.a3zt.madeup.Remote.UserService;
import com.example.a3zt.madeup.SharedPackage.Class.Response;
import com.example.a3zt.madeup.SharedPackage.Class.SharedParameter;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {


    private Dialog progressDialog;
    private EditText Edt_Email , Edt_Password  ;
    private Button Login;
    private UserService userService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shared_login);


        InitComponent();

        loginOnClick();


    }



    private void InitComponent()
    {
        Login=findViewById(R.id.bt_login);
        Edt_Email = findViewById(R.id.Edt_Login_Email);
        Edt_Password = findViewById(R.id.Edt_Login_Password);


        userService = ApiUtlis.getUserService();
    }



    private void loginOnClick(){
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(Edt_Email.getText().toString().trim(),Edt_Password.getText().toString().trim());
            }
        });
    }

    private void loginUser(String Email,String Password) {

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            Edt_Email.setError(getResources().getString(R.string.PleaseEnterYourEmail));
            Edt_Email.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(Password)){
            Edt_Password.setError(getResources().getString(R.string.PleaseEnterYourPassword));
            Edt_Password.requestFocus();
            return;
        }

        callLogin(Email , Password);
    }

    private void callLogin(String email , String password) {
        ShowWaiting();
        Call<Response> call = userService.Login(email, password);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful())
                {
                    if(response.body().getValue())
                    {
                        if (response.body().getData().getRole().equals( SharedParameter.Customer))
                        {
                            Toast.makeText(LoginActivity.this, "customer", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, SellerHomeActivity.class));
                        }
                        else if (response.body().getData().getRole().equals(SharedParameter.Supplier))
                        {
                            Toast.makeText(LoginActivity.this, "seller", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, SellerHomeActivity.class));
                        }
                        progressDialog.dismiss();
                    }
                    else {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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
