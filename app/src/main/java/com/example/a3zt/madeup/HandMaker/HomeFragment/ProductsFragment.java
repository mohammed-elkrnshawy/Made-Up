package com.example.a3zt.madeup.HandMaker.HomeFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.Remote.ApiUtlis;
import com.example.a3zt.madeup.Remote.UserService;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.ResponseProduct;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("ValidFragment")
public class ProductsFragment extends Fragment {

    private String UserID,UserToken;
    private UserService userService;
    private View view;

    @SuppressLint("ValidFragment")
    public ProductsFragment(String UserID, String UserToken)
    {
        this.UserID=UserID;
        this.UserToken=UserToken;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_seller_products , container , false) ;


        userService = ApiUtlis.getUserService();


        callUserProduct();

        return view;
    }

    private void callUserProduct()
    {
        Call<ResponseProduct> call= userService.allProductsUser(UserID,"Bearer "+UserToken,"en");
        call.enqueue(new Callback<ResponseProduct>() {
            @Override
            public void onResponse(Call<ResponseProduct> call, Response<ResponseProduct> response) {
                if(response.isSuccessful())
                {
                    Toast.makeText(getActivity(), response.body().getData().getProducts().get(0).getName(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseProduct> call, Throwable t) {

            }
        });
    }
}
