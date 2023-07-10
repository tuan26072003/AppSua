package com.example.food.Domain.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food.Activity.showdetail;
import com.example.food.Domain.FoodDomain;
import com.example.food.R;

import java.util.ArrayList;

public class PoplurarAdaptor extends RecyclerView.Adapter<PoplurarAdaptor.ViewHolder> {
    ArrayList<FoodDomain> popluraFood;

    public PoplurarAdaptor(ArrayList<FoodDomain> popluraFood) {
        this.popluraFood = popluraFood;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PoplurarAdaptor.ViewHolder holder, int position) {
        holder.title.setText(popluraFood.get(position).getTitle());
        holder.fee.setText(String.valueOf(popluraFood.get(position).getFee()));
        String picName = popluraFood.get(position).getPic();
        if (picName != null) {
            int drawableResourceId = holder.itemView.getContext().getResources()
                    .getIdentifier(picName, "drawable", holder.itemView.getContext().getPackageName());
            if (drawableResourceId != 0) {
                Glide.with(holder.itemView.getContext())
                        .load(drawableResourceId)
                        .into(holder.pic);
            }
        }
        holder.addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.itemView.getContext(), showdetail.class);
                intent.putExtra("object",popluraFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return popluraFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        TextView addbtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tile);
            fee=itemView.findViewById(R.id.fee);
            addbtn=itemView.findViewById(R.id.adbtn);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
