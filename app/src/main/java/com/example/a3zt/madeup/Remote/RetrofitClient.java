package com.example.a3zt.madeup.Remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit=null;


    public static Retrofit getClient(String Url) {
        if (retrofit==null)
        {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit=new Retrofit.Builder()
                    .baseUrl(Url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }
        return retrofit;
    }

    public static void setRetrofit(Retrofit retrofit) {
        RetrofitClient.retrofit = retrofit;
    }
}
