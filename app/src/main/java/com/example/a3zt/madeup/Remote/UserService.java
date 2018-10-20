package com.example.a3zt.madeup.Remote;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.Image;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.Tag;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseUsers.ResponseUser;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.ResponseProduct;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {


    @POST("auth/register/customer")
    Call<ResponseUser> RegisterCustomer(
            @Query("name") String name ,
            @Query("phone") String phone ,
            @Query("email") String email ,
            @Query("password") String password
    );


 @POST("auth/register/seller")
    Call<ResponseUser> RegisterSeller(
            @Query("name") String name ,
            @Query("phone") String phone ,
            @Query("email") String email ,
            @Query("password") String password
    );

 @POST("auth/login")
    Call<ResponseUser> Login(
            @Query("email") String email ,
            @Query("password") String password
 );


    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("product/seller/{id}")
    Call<ResponseProduct> allProductsUser(
            @Path("id") String userID,
            @Header("Authorization") String Token,
            @Header("X-localization") String Localization
    );


    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("profile")
    Call<ResponseUser> userProfile(
            @Header("Authorization") String Token
    );

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @Multipart
    @POST("product")
    Call<ResponseProduct> storeProduct(
                    @Header("Authorization") String Token ,
                     @Query("ar_name") String ar_name ,
                    @Query("price") String price ,
                    @Query("category_id") int category_id ,
                    @Query("tags[]") List<String> tags ,
                    @Part MultipartBody.Part main_image ,
                     @Part MultipartBody.Part [] images ,
                     @Query("en_name") String en_name ,
                     @Query("ar_description") String ar_description ,
                     @Query("en_description") String en_description
            );



}
