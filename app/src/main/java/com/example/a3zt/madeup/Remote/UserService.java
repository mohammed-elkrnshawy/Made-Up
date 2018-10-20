package com.example.a3zt.madeup.Remote;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseUsers.ResponseUser;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.ResponseProduct;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
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
    @GET("category")
    Call<ResponseUser> categories(
            @Header("Authorization") String Token,
            @Header("X-localization") String Localization
    );

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("profile")
    Call<ResponseUser> userProfile(
            @Header("Authorization") String Token
    );

}
