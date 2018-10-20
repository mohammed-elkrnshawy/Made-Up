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


    private EditText Edt_ProductName , Edt_ProductName_EN , Edt_ProductPrice , Edt_ProductDesc , Edt_ProductDesc_EN , Edt_ProductKyewords , Edt_ProductKyewords_EN ;
    private TextInputLayout inputLayoutName , inputLayoutName_EN, inputLayoutPrice, inputLayoutDesc , inputLayoutDesc_EN , inputLayoutKeywords ,inputLayoutKeywords_EN ;
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
        Edt_ProductName = findViewById(R.id.productName_ar) ;
        Edt_ProductName_EN = findViewById(R.id.productName_en) ;
        Edt_ProductPrice = findViewById(R.id.productPrice) ;
        Edt_ProductDesc = findViewById(R.id.productDesc_ar) ;
        Edt_ProductDesc_EN = findViewById(R.id.productDesc_en) ;
        Edt_ProductKyewords = findViewById(R.id.productKeyWords_ar) ;
        Edt_ProductKyewords_EN = findViewById(R.id.productKeyWords_en) ;
        inputLayoutName = findViewById(R.id.input_layout_name_ar);
        inputLayoutName_EN = findViewById(R.id.input_layout_name_en);
        inputLayoutPrice = findViewById(R.id.input_layout_price);
        inputLayoutDesc = findViewById(R.id.input_layout_description_ar);
        inputLayoutDesc_EN = findViewById(R.id.input_layout_description_en);
        inputLayoutKeywords = findViewById(R.id.input_layout_keywords_ar);
        inputLayoutKeywords_EN = findViewById(R.id.input_layout_keywords_en);
        Btn_Add = findViewById(R.id.ADD);
        PhotoPicker = findViewById(R.id.photoPicker) ;
    }

    private void EditChangeListener() {
        Edt_ProductName.addTextChangedListener(new MyTextWatcher(Edt_ProductName));
        Edt_ProductName_EN.addTextChangedListener(new MyTextWatcher(Edt_ProductName_EN));
        Edt_ProductPrice.addTextChangedListener(new MyTextWatcher(Edt_ProductPrice));
        Edt_ProductDesc.addTextChangedListener(new MyTextWatcher(Edt_ProductDesc));
        Edt_ProductDesc_EN.addTextChangedListener(new MyTextWatcher(Edt_ProductDesc_EN));
        Edt_ProductKyewords.addTextChangedListener(new MyTextWatcher(Edt_ProductKyewords));
        Edt_ProductKyewords_EN.addTextChangedListener(new MyTextWatcher(Edt_ProductKyewords_EN));
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

        if(!validateName_EN()){
            return;
        }

        if(!validatePrice()){
            return;
        }

        if(!validateDesc()){
            return;
        }

        if(!validateDesc_EN()){
            return;
        }

        if(!validateKeywords()){
            return;
        }

        if(!validateKeywords_EN()){
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

    private Boolean validateName_EN(){
        final  String ProductName = Edt_ProductName_EN.getText().toString().trim() ;
        if (TextUtils.isEmpty(ProductName)){
            inputLayoutName_EN.setError(getString(R.string.required));
            requestFocus(Edt_ProductName_EN);
        }else {
            inputLayoutName_EN.setErrorEnabled(false);
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

    private Boolean validateDesc_EN(){
        final  String ProductDesc = Edt_ProductDesc_EN.getText().toString().trim() ;
        if (TextUtils.isEmpty(ProductDesc)){
            inputLayoutDesc_EN.setError(getString(R.string.required));
            requestFocus(Edt_ProductDesc_EN);
        }else {
            inputLayoutDesc_EN.setErrorEnabled(false);
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

    private Boolean validateKeywords_EN(){
        final  String ProductKeywords = Edt_ProductKyewords_EN.getText().toString().trim() ;
        if (TextUtils.isEmpty(ProductKeywords)){
            inputLayoutKeywords_EN.setError(getString(R.string.required));
            requestFocus(Edt_ProductKyewords_EN);
        }else {
            inputLayoutKeywords_EN.setErrorEnabled(false);
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
                case R.id.productName_ar :
                    validateName() ;
                    break;
                case R.id.productName_en :
                    validateName_EN() ;
                    break;
                case R.id.productPrice :
                    validatePrice() ;
                    break;
                case R.id.productDesc_ar :
                    validateDesc() ;
                    break;
                case R.id.productDesc_en :
                    validateDesc_EN() ;
                    break;
                case R.id.productKeyWords_ar :
                    validateKeywords();
                    break;
                case R.id.productKeyWords_en :
                    validateKeywords_EN();
                    break;
            }
        }
    }

}
