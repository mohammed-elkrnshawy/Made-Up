package com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("paginate")
    @Expose
    private Paginate paginate;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Paginate getPaginate() {
        return paginate;
    }

    public void setPaginate(Paginate paginate) {
        this.paginate = paginate;
    }

}