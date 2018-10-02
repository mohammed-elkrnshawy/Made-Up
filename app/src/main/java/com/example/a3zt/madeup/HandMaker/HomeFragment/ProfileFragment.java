package com.example.a3zt.madeup.HandMaker.HomeFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseUsers.DataUser;

@SuppressLint("ValidFragment")
public class ProfileFragment extends Fragment {

    private DataUser user;
    private View view;

    @SuppressLint("ValidFragment")
    public ProfileFragment(DataUser user)
    {
        this.user=user;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_seller_profile , container , false) ;



        return view;
    }
}
