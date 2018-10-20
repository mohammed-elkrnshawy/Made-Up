package com.example.a3zt.madeup.SharedPackage.Class.ResponseCategories;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryResponse {

    @SerializedName("value")
    @Expose
    private Boolean value;
    @SerializedName("data")
    @Expose
    private List<List<CategoryData>> data = null;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public List<List<CategoryData>> getData() {
        return data;
    }

    public void setData(List<List<CategoryData>> data) {
        this.data = data;
    }

}