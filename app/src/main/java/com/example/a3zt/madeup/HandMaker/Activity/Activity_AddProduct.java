package com.example.a3zt.madeup.HandMaker.Activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.Remote.ApiUtlis;
import com.example.a3zt.madeup.Remote.RetrofitClient;
import com.example.a3zt.madeup.Remote.UserService;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.Image;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.ResponseProduct;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.Tag;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_AddProduct extends AppCompatActivity {


    private static final int PICK_IMAGE_REQUEST = 1 ;
    private static final int TAKE_IMAGE_REQUEST = 2 ;
    private boolean FIRST_REQUEST = false ;
    private boolean SECOND_REQUEST = false ;
    private boolean THIRD_REQUEST = false ;
    private boolean FOURTH_REQUEST = false ;
    private boolean FIFTH_REQUEST = false ;


    private File file;
    private MultipartBody.Part body ,  mainBody;
    private MultipartBody.Part [] imageList = new MultipartBody.Part[4];
    private Uri mImgUri ;
    private EditText Edt_ProductName , Edt_ProductName_EN , Edt_ProductPrice , Edt_ProductDesc , Edt_ProductDesc_EN , Edt_ProductKyewords  ;
    private TextInputLayout inputLayoutName , inputLayoutName_EN, inputLayoutPrice, inputLayoutDesc , inputLayoutDesc_EN , inputLayoutKeywords  ;
    private Button Btn_Add  ;
    private ImageView PhotoPickerMain , PhotoPicker2 , PhotoPicker3  , PhotoPicker4 , PhotoPicker5 ;

    private String token ;


    UserService userService ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saller_add__product);
        initView();

        EditChangeListener();

        AddOnClick();

    }



    private void initView() {
        userService = ApiUtlis.getUserService() ;
        getUserIntent();
        Edt_ProductName = findViewById(R.id.productName_ar) ;
        Edt_ProductName_EN = findViewById(R.id.productName_en) ;
        Edt_ProductPrice = findViewById(R.id.productPrice) ;
        Edt_ProductDesc = findViewById(R.id.productDesc_ar) ;
        Edt_ProductDesc_EN = findViewById(R.id.productDesc_en) ;
        Edt_ProductKyewords = findViewById(R.id.productKeyWords_ar) ;
        inputLayoutName = findViewById(R.id.input_layout_name_ar);
        inputLayoutName_EN = findViewById(R.id.input_layout_name_en);
        inputLayoutPrice = findViewById(R.id.input_layout_price);
        inputLayoutDesc = findViewById(R.id.input_layout_description_ar);
        inputLayoutDesc_EN = findViewById(R.id.input_layout_description_en);
        inputLayoutKeywords = findViewById(R.id.input_layout_keywords_ar);
        Btn_Add = findViewById(R.id.ADD);
        PhotoPickerMain = findViewById(R.id.photoPicker) ;
        PhotoPicker2 = findViewById(R.id.photoPicker2) ;
        PhotoPicker3 = findViewById(R.id.photoPicker3) ;
        PhotoPicker4 = findViewById(R.id.photoPicker4) ;
        PhotoPicker5 = findViewById(R.id.photoPicker5) ;

        AddMainPhoto();
        AddPhoto2();
        AddPhoto3();
        AddPhoto4();
        AddPhoto5();
    }

    private void EditChangeListener() {
        Edt_ProductName.addTextChangedListener(new MyTextWatcher(Edt_ProductName));
        Edt_ProductName_EN.addTextChangedListener(new MyTextWatcher(Edt_ProductName_EN));
        Edt_ProductPrice.addTextChangedListener(new MyTextWatcher(Edt_ProductPrice));
        Edt_ProductDesc.addTextChangedListener(new MyTextWatcher(Edt_ProductDesc));
        Edt_ProductDesc_EN.addTextChangedListener(new MyTextWatcher(Edt_ProductDesc_EN));
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

    private void AddMainPhoto(){
        PhotoPickerMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FIRST_REQUEST = true ;
                SECOND_REQUEST = false ;
                THIRD_REQUEST = false ;
                FOURTH_REQUEST = false ;
                FIFTH_REQUEST = false ;
                popUpDialog();
            }
        });
    }

    private void AddPhoto2(){
        PhotoPicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FIRST_REQUEST = false ;
                SECOND_REQUEST = true ;
                THIRD_REQUEST = false ;
                FOURTH_REQUEST = false ;
                FIFTH_REQUEST = false ;
                popUpDialog();
            }
        });
    }

    private void AddPhoto3(){
        PhotoPicker3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FIRST_REQUEST = false ;
                SECOND_REQUEST = false ;
                THIRD_REQUEST = true ;
                FOURTH_REQUEST = false ;
                FIFTH_REQUEST = false ;
                popUpDialog();
            }
        });
    }

    private void AddPhoto4(){
        PhotoPicker4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FIRST_REQUEST = false ;
                SECOND_REQUEST = false ;
                THIRD_REQUEST = false ;
                FOURTH_REQUEST = true ;
                FIFTH_REQUEST = false ;
                popUpDialog();
            }
        });
    }

    private void AddPhoto5(){
        PhotoPicker5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FIRST_REQUEST = false ;
                SECOND_REQUEST = false ;
                THIRD_REQUEST = false ;
                FOURTH_REQUEST = false ;
                FIFTH_REQUEST = true ;
                popUpDialog();
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


//        if (PhotoPickerMain == null){
//            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//        }

        persistMainImage(PhotoPickerMain , "Photo");
        persistImageLicense(PhotoPicker2 , "photo2" , 0);
        persistImageLicense(PhotoPicker3 , "photo3" , 1);
        persistImageLicense(PhotoPicker4 , "photo4" , 2);
        persistImageLicense(PhotoPicker5 , "photo5" , 3);


        //TODO DB

//        callAddProduct(token , Edt_ProductName.getText().toString().trim() ,
//                       Edt_ProductPrice.getText().toString().trim() ,
//                        Edt_ProductKyewords.getText().toString().trim() ,
//                        );


    }

    private void getUserIntent(){
        Intent i = getIntent();
        token = i.getStringExtra("user") ;
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



    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private void callAddProduct(String token , String ar_name , String price , int category_id , List<String> tags , MultipartBody.Part image , MultipartBody.Part [] images , String en_name , String ar_description , String en_description){

        Call<ResponseProduct> call = userService.storeProduct(token , ar_name , price  ,  category_id , tags , image , images , en_name , ar_description , en_description);
        call.enqueue(new Callback<ResponseProduct>() {
            @Override
            public void onResponse(Call<ResponseProduct> call, Response<ResponseProduct> response) {
                Toast.makeText(Activity_AddProduct.this, "Product is added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseProduct> call, Throwable t) {

            }
        });
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
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //choosephoto
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK &&
                data != null && data.getData() != null ){

            mImgUri = data.getData() ;
            try {
                Bitmap photo = MediaStore.Images.Media.getBitmap(this.getContentResolver(), mImgUri);

                if(FIRST_REQUEST){
                    PhotoPickerMain.setImageBitmap(photo);
                }else if (SECOND_REQUEST){
                    PhotoPicker2.setImageBitmap(photo);
                }else if (THIRD_REQUEST){
                    PhotoPicker3.setImageBitmap(photo);
                }else if (FOURTH_REQUEST){
                    PhotoPicker4.setImageBitmap(photo);
                }else if (FIFTH_REQUEST){
                    PhotoPicker5.setImageBitmap(photo);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(requestCode == TAKE_IMAGE_REQUEST && resultCode == RESULT_OK &&
                data != null && data.getData() != null ){

            Bitmap image = (Bitmap) data.getExtras().get("data");

            if(FIRST_REQUEST){
                PhotoPickerMain.setImageBitmap(image);
            }else if (SECOND_REQUEST){
                PhotoPicker2.setImageBitmap(image);
            }else if (THIRD_REQUEST){
                PhotoPicker3.setImageBitmap(image);
            }else if (FOURTH_REQUEST){
                PhotoPicker4.setImageBitmap(image);
            }else if (FIFTH_REQUEST){
                PhotoPicker5.setImageBitmap(image);
            }
        }
    }

    private void choosePhoto(){
        Intent intent = new Intent();
        intent.setType("image/*") ;
        intent.setAction(Intent.ACTION_GET_CONTENT) ;
        startActivityForResult(intent , PICK_IMAGE_REQUEST);
    }
    private void takePhoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent , TAKE_IMAGE_REQUEST);
    }

    private void popUpDialog(){
        final Dialog dialog = new Dialog(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View Layout_choose = inflater.inflate(R.layout.view_choose_image, null);
        Button choosePhotoBtn = Layout_choose.findViewById(R.id.choose_photo_btn);
        Button takePhotoBtn = Layout_choose.findViewById(R.id.take_photo_btn);
        dialog.setContentView(Layout_choose);

        choosePhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoto();
                dialog.dismiss();
            }
        });

        takePhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
                dialog.dismiss();
            }
        });


        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

//    private void ConvertPhoto() {
//        persistImageLicense(PhotoPickerMain,"license");
//    }

    private void persistMainImage(ImageView imageView, String name  ) {

        imageView.buildDrawingCache();
        Bitmap bitmap = imageView.getDrawingCache();


        File filesDir = this.getFilesDir();
        file = new File(filesDir, name + ".jpg");

        OutputStream os;
        try {

            os = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
            os.flush();
            os.close();
        } catch (Exception e) {
            Toast.makeText(this, "select photo", Toast.LENGTH_SHORT).show();
            Log.e("Error writing bitmap", e.getMessage());
        }

        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        mainBody = MultipartBody.Part.createFormData("license_photo", file.getName(), requestFile);



        if (mainBody==null)
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    private void persistImageLicense(ImageView imageView, String name , int i ) {

        imageView.buildDrawingCache();
        Bitmap bitmap = imageView.getDrawingCache();


        File filesDir = this.getFilesDir();
        file = new File(filesDir, name + ".jpg");

        OutputStream os;
        try {

            os = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
            os.flush();
            os.close();
        } catch (Exception e) {
            Toast.makeText(this, "select photo", Toast.LENGTH_SHORT).show();
            Log.e("Error writing bitmap", e.getMessage());
        }

        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        body = MultipartBody.Part.createFormData("license_photo", file.getName(), requestFile);

        imageList[i] = body ;

        if (body==null)
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
