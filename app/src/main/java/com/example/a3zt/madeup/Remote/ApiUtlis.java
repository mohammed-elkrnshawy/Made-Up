package com.example.a3zt.madeup.Remote;

public class ApiUtlis {
    //public static final String Base_Url="http://52.224.66.22/abdullah/hint/hint/public/";
    public static final String Base_Url="https://maps.googleapis.com/maps/";

    public static UserService getUserService()
    {
        return RetrofitClient.getClient(Base_Url).create(UserService.class);
    }
}
