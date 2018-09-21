package com.example.a3zt.madeup.Remote;

public class ApiUtlis {
    //public static final String Base_Url="http://52.224.66.22/abdullah/hint/hint/public/";
    public static final String Base_Url="192.168.0.105:8000/api/";

    public static UserService getUserService()
    {
        return RetrofitClient.getClient(Base_Url).create(UserService.class);
    }
}
