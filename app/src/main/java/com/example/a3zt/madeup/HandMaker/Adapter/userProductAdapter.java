package com.example.a3zt.madeup.HandMaker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.Image;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts.Product;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 3ZT on 10/23/2017.
 */

public class userProductAdapter extends RecyclerView.Adapter<userProductAdapter.MyViewHolder> {

    private Context mContext;
    private List<Product> albumList;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView txtProductName,txtPrice;
        public ImageView imgProduct;
        public CardView sellerCardView;

        public MyViewHolder(View view) {
            super(view);
            txtPrice=view.findViewById(R.id.txtPrice);
            txtProductName =  view.findViewById(R.id.txtProductName);
            imgProduct =  view.findViewById(R.id.imgProduct);
            sellerCardView=view.findViewById(R.id.sellerCardView);
        }
    }


    public userProductAdapter(Context mContext, List<Product> albumList ) {
        this.mContext = mContext;
        this.albumList = albumList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_seller_product, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final Product album = albumList.get(position);
        holder.txtProductName.setText(album.getName());
        holder.txtPrice.setText(album.getPrice());



        List<Image> imageList=album.getImages();

        for(Image image:imageList)
        {
            if (image.getIsMain().equals("1"))
            {
                ImageLoader.getInstance().displayImage(image.getImage(), holder.imgProduct, new ImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                        //finalHolder.progressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                        //finalHolder.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        //finalHolder.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onLoadingCancelled(String imageUri, View view) {
                        //finalHolder.progressBar.setVisibility(View.GONE);
                    }
                });
                break;
            }
        }


        /*holder.relativeLayoutParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // SharedParameters.DoctorUid=album.DoctorID;
              //  Toast.makeText(mContext, album.DoctorID, Toast.LENGTH_SHORT).show();
             //  mContext.startActivity(new Intent(mContext,PatientViewDoctorActivity.class));
                        Intent intent=new Intent(mContext,PatientViewDoctorActivity.class);
                        intent.putExtra("Patient ID",aClass.PatientID);
                        intent.putExtra("Doctor ID",album.DoctorID);
                        intent.putExtra("Patient Name",aClass.PatientName);
                        mContext.startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

}

