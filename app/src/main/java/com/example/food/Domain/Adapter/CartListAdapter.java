package com.example.food.Domain.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food.Activity.CartListActivity;
import com.example.food.Domain.FoodDomain;
import com.example.food.Helper.ManagemenCart;
import com.example.food.R;
import com.example.food.interfa.ChangeNumberITemListenr;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private ArrayList<FoodDomain> foodDomains;
    private ManagemenCart managemenCart;
    private ChangeNumberITemListenr changeNumberITemListenr;

    public CartListAdapter(ArrayList<FoodDomain> foodDomains, Context context, ChangeNumberITemListenr changeNumberITemListenr) {
        this.foodDomains = foodDomains;
        this.managemenCart = new ManagemenCart((CartListActivity) context);
        this.changeNumberITemListenr = changeNumberITemListenr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodDomain food = foodDomains.get(position);

        holder.title.setText(food.getTitle());
        holder.feeEachItem.setText(String.valueOf(food.getFee()));
        holder.totalEachItem.setText(String.valueOf(Math.round(food.getNumberaIncart() * food.getFee() * 100) / 100));
        holder.num.setText(String.valueOf(food.getNumberaIncart()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(food.getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.plusCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managemenCart.plusNumberFood(foodDomains, position, new ChangeNumberITemListenr() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberITemListenr.changed();
                    }
                });
            }
        });

        holder.minusCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managemenCart.minusNumberFood(foodDomains, position, new ChangeNumberITemListenr() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberITemListenr.changed();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem, totalEachItem, num;
        ImageView pic, plusCart, minusCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxtcarta);
            feeEachItem = itemView.findViewById(R.id.feeEachitem);
            totalEachItem = itemView.findViewById(R.id.totialFeetxta);
            num = itemView.findViewById(R.id.numbeCart);
            pic = itemView.findViewById(R.id.picCart);
            plusCart = itemView.findViewById(R.id.plusCart);
            minusCart = itemView.findViewById(R.id.minusCart);
        }
    }
}
