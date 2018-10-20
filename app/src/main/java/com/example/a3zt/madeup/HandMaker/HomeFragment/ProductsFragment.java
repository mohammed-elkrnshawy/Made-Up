package com.example.a3zt.madeup.HandMaker.HomeFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a3zt.madeup.HandMaker.Adapter.userProductAdapter;
import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.Remote.ApiUtlis;
import com.example.a3zt.madeup.Remote.UserService;
import com.example.a3zt.madeup.SharedPackage.Class.GridSpacingItemDecoration;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.Product;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.ResponseProduct;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseUsers.DataUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("ValidFragment")
public class ProductsFragment extends Fragment {

    private GridSpacingItemDecoration gridSpacingItemDecoration;

    private RecyclerView recyclerProducts;
    private userProductAdapter productAdapter;
    private DataUser user;
    private UserService userService;
    private View view;

    @SuppressLint("ValidFragment")
    public ProductsFragment(DataUser user)
    {
        this.user=user;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_seller_products , container , false) ;

        InitComponent();

        callUserProduct();

        return view;
    }

    private void InitComponent() {

        Log.d("AASDD",user.getToken());

        userService = ApiUtlis.getUserService();

        recyclerProducts=view.findViewById(R.id.recycle_Products);
    }

    private void callUserProduct()
    {
        Call<ResponseProduct> call= userService.allProductsUser(user.getId(),"Bearer "+user.getToken(),"en");
        call.enqueue(new Callback<ResponseProduct>() {
            @Override
            public void onResponse(Call<ResponseProduct> call, Response<ResponseProduct> response) {
                if(response.isSuccessful())
                {
                    showResult(response.body().getData().getProducts());
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

    private void showResult(List<Product> products) {

        productAdapter=new userProductAdapter(getActivity(),products);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerProducts.setLayoutManager(mLayoutManager);
        gridSpacingItemDecoration=new GridSpacingItemDecoration (2,0,true,getActivity());
        recyclerProducts.addItemDecoration(gridSpacingItemDecoration);
        recyclerProducts.setItemAnimator(new DefaultItemAnimator());
        recyclerProducts.setAdapter(productAdapter);
    }
}
