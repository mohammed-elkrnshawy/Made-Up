package com.example.a3zt.madeup.Remote;

public class ApiUtlis {

    public static final String Base_Url="http://madeup.amlla.org/api/";

    public static UserService getUserService()
    {
        return RetrofitClient.getClient(Base_Url).create(UserService.class);
    }
}
