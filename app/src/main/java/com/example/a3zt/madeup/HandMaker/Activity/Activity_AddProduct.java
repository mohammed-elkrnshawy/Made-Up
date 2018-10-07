package com.example.a3zt.madeup.HandMaker.Activity;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.a3zt.madeup.R;

public class Activity_AddProduct extends AppCompatActivity {


    private EditText Edt_ProductName , Edt_ProductPrice , Edt_ProductDesc , Edt_ProductKyewords ;
    private TextInputLayout inputLayoutName, inputLayoutPrice, inputLayoutDesc , inputLayoutKeywords ;
    private Button Btn_Add  ;
    private ImageButton PhotoPicker ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saller_add__product);
        initView();

        EditChangeListener();

        AddOnClick();

    }



    private void initView() {
        Edt_ProductName = findViewById(R.id.productName) ;
        Edt_ProductPrice = findViewById(R.id.productPrice) ;
        Edt_ProductDesc = findViewById(R.id.productDesc) ;
        Edt_ProductKyewords = findViewById(R.id.productKeyWords) ;
        inputLayoutName = findViewById(R.id.input_layout_name);
        inputLayoutPrice = findViewById(R.id.input_layout_price);
        inputLayoutDesc = findViewById(R.id.input_layout_description);
        inputLayoutKeywords = findViewById(R.id.input_layout_keywords);
        Btn_Add = findViewById(R.id.ADD);
        PhotoPicker = findViewById(R.id.photoPicker) ;
    }

    private void EditChangeListener() {
        Edt_ProductName.addTextChangedListener(new MyTextWatcher(Edt_ProductName));
        Edt_ProductPrice.addTextChangedListener(new MyTextWatcher(Edt_ProductPrice));
        Edt_ProductDesc.addTextChangedListener(new MyTextWatcher(Edt_ProductDesc));
        Edt_ProductKyewords.addTextChangedListener(new MyTextWatcher(Edt_ProductKyewords));
    }

    private void AddOnClick() {

        Btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }
    private void submitForm(){
        if(!validateName()){
            return;
        }

        if(!validatePrice()){
            return;
        }

        if(!validateDesc()){
            return;
        }

        if(!validateKeywords()){
            return;
        }

        //TODO DB
    }

    private Boolean validateName(){
        final  String ProductName = Edt_ProductName.getText().toString().trim() ;
        if (TextUtils.isEmpty(ProductName)){
            inputLayoutName.setError(getString(R.string.required));
            requestFocus(Edt_ProductName);
        }else {
            inputLayoutName.setErrorEnabled(false);
        }
        return true;
    }

    private Boolean validatePrice(){
        final  String ProductPrice = Edt_ProductPrice.getText().toString().trim() ;
        if (TextUtils.isEmpty(ProductPrice)){
            inputLayoutPrice.setError(getString(R.string.required));
            requestFocus(Edt_ProductPrice);
        }else {
            inputLayoutPrice.setErrorEnabled(false);
        }
        return true;
    }

    private Boolean validateDesc(){
        final  String ProductDesc = Edt_ProductDesc.getText().toString().trim() ;
        if (TextUtils.isEmpty(ProductDesc)){
            inputLayoutDesc.setError(getString(R.string.required));
            requestFocus(Edt_ProductDesc);
        }else {
            inputLayoutDesc.setErrorEnabled(false);
        }
        return true;
    }

    private Boolean validateKeywords(){
        final  String ProductKeywords = Edt_ProductKyewords.getText().toString().trim() ;
        if (TextUtils.isEmpty(ProductKeywords)){
            inputLayoutKeywords.setError(getString(R.string.required));
            requestFocus(Edt_ProductKyewords);
        }else {
            inputLayoutKeywords.setErrorEnabled(false);
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view ;

        public MyTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            switch (view.getId()){
                case R.id.productName :
                    validateName() ;
                    break;
                case R.id.productPrice :
                    validatePrice() ;
                    break;
                case R.id.productDesc :
                    validateDesc() ;
                    break;
                case R.id.productKeyWords :
                    validateKeywords();
                    break;
            }
        }
    }

}
