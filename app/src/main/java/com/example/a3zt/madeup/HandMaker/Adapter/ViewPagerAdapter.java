package com.example.a3zt.madeup.HandMaker.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.Image;
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
        
        Picasso.get()
                .load(Images.get(position).getImage())
                .fit()
                .into(imageView);
        container.addView(imageView);
        return imageView ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
