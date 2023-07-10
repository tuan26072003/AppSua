package com.example.food.Domain.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food.Domain.CategoryDomain;
import com.example.food.R;

import java.util.ArrayList;

public class CategoryAdaptor  extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {
    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdaptor(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdaptor.ViewHolder holder, int position) {

    String picUrl="";
    switch (position){
        case 0:{
            picUrl="cat_1";
            holder.mainlyaout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_backgroun));
            holder.categoryName.setText(categoryDomains.get(position).getTitle());
        }
        break;
        case 1:{
            picUrl="cat_2";
            holder.mainlyaout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_backgroun2));
            holder.categoryName.setText(categoryDomains.get(position).getTitle());
        }
        break;

        case 2:{
            picUrl="cat_3";
            holder.mainlyaout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_backgroun3));
            holder.categoryName.setText(categoryDomains.get(position).getTitle());
        }
        break;

        case 3:{
            picUrl="cat_4";
            holder.mainlyaout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_backgroun4));
            holder.categoryName.setText(categoryDomains.get(position).getTitle());
        }
        break;
        case 4:{
            picUrl="cat_5";
            holder.mainlyaout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_backgroun5));
            holder.categoryName.setText(categoryDomains.get(position).getTitle());
        }
    }
    int drawableResoureceId=holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResoureceId).into(holder.categorypic);
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categorypic;
        ConstraintLayout mainlyaout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName=itemView.findViewById(R.id.categoryPicname);
            categorypic=itemView.findViewById(R.id.categoryPic);
            mainlyaout=itemView.findViewById(R.id.mainLayout);

        }
    }
}
