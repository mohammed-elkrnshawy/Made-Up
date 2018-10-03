package com.example.a3zt.madeup.HandMaker.HomeFragment;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseUsers.DataUser;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import de.hdodenhof.circleimageview.CircleImageView;

@SuppressLint("ValidFragment")
public class ProfileFragment extends Fragment {

    private CircleImageView image_Profile;
    private TextView textName;
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

        InitComponent();


        showData();

        return view;
    }

    private void showData() {
        ImageLoader.getInstance().displayImage(user.getPhone(), image_Profile, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
        textName.setText(user.getName());
    }

    private void InitComponent() {
        image_Profile=view.findViewById(R.id.image_profile);
        textName=view.findViewById(R.id.txtName);
    }
}
