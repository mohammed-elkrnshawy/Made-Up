package com.example.a3zt.madeup.Remote;
import com.example.a3zt.madeup.SharedPackage.Class.Response;

import retrofit2.Call;
import retrofit2.http.POST;
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



}
