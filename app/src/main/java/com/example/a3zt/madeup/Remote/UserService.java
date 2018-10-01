package com.example.a3zt.madeup.Remote;
import com.example.a3zt.madeup.SharedPackage.Class.Response;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.ResponseProduct;
import com.example.a3zt.madeup.SharedPackage.Class.SharedParameter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {


    @POST("auth/register/customer")
    Call<Response> RegisterCustomer(
            @Query("name") String name ,
            @Query("phone") String phone ,
            @Query("email") String email ,
            @Query("password") String password
    );


 @POST("auth/register/seller")
    Call<Response> RegisterSeller(
            @Query("name") String name ,
            @Query("phone") String phone ,
            @Query("email") String email ,
            @Query("password") String password
    );

 @POST("auth/login")
    Call<Response> Login(
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

}
