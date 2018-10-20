package com.example.a3zt.madeup.SharedPackage.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a3zt.madeup.R;
import com.example.a3zt.madeup.SharedPackage.Class.ResponseCategories.CategoryData;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {

    List<CategoryData> categoryDataList;
    Context context;

    public CategoryAdapter(List<CategoryData> categoryDataList,Context context)
    {
        this.categoryDataList=categoryDataList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return categoryDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return categoryDataList.indexOf(categoryDataList.get(position));
    }

    class ViewHolder
    {
        TextView CategoryText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;

        LayoutInflater mIFlater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View row=mIFlater.inflate(R.layout.view_spinner,parent,false);

        holder=new CategoryAdapter.ViewHolder();

        holder.CategoryText=row.findViewById(R.id.spinnerView);



        holder.CategoryText.setText(categoryDataList.get(position).getName());
        return row;
    }
}
