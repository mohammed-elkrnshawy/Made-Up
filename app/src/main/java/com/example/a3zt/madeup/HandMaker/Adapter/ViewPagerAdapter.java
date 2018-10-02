package com.example.a3zt.madeup.HandMaker.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.Image;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

   private Context context ;
   private List<Image> Images ;

    public ViewPagerAdapter(Context context, List<Image> images) {
        this.context = context;
        Images = images;
    }

    @Override
    public int getCount() {
        return Images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object ;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        ImageLoader.getInstance().displayImage(
                Images.get(position).getImage(),
                imageView, new ImageLoadingListener() {
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
                }
        );

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);
        return imageView ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
