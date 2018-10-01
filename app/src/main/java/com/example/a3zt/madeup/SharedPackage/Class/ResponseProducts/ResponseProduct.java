package com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseProduct {

    @SerializedName("value")
    @Expose
    private Boolean value;
    @SerializedName("data")
    @Expose
    private Data data;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}