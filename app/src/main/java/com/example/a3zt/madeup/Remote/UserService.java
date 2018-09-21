package com.example.a3zt.madeup.Remote;
import com.example.a3zt.madeup.SharedPackage.Class.Response;

import retrofit2.Call;
import retrofit2.http.POST;

public interface UserService {


    @POST("auth/register/customer")
    Call<Response> set();


}
