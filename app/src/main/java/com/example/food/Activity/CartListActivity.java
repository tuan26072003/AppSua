package com.example.food.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.food.Domain.Adapter.CartListAdapter;
import com.example.food.Helper.ManagemenCart;
import com.example.food.Helper.TinyDB;
import com.example.food.R;
import com.example.food.interfa.ChangeNumberITemListenr;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CartListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private CartListAdapter adapter;
    private ManagemenCart managemenCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managemenCart = new ManagemenCart(this, new TinyDB(this));

        initView();
        initList();
        calculateCart();
        setupBottomNavigation();
    }

    private void initView() {
        recyclerView = findViewById(R.id.cartview);
        totalFeeTxt = findViewById(R.id.totialFeetxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deiveryTxt);
        totalTxt = findViewById(R.id.hi);
        emptyTxt = findViewById(R.id.empty);
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new CartListAdapter(managemenCart.getListCart(), this, new ChangeNumberITemListenr() {
            @Override
            public void changed() {
                calculateCart();
            }
        });
        recyclerView.setAdapter(adapter);

        if (managemenCart.getListCart().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCart() {
        double percentTax = 0.02;
        double delivery = 10;

        double tax = Math.round((managemenCart.getTotalfee() * percentTax) * 100) / 100;
        double total = Math.round((managemenCart.getTotalfee() + tax + delivery) * 100) / 100;
        double itemTotal = Math.round(managemenCart.getTotalfee() * 100) / 100;

        totalFeeTxt.setText("$" + itemTotal);
        taxTxt.setText("$" + tax);
        deliveryTxt.setText("$" + delivery);
        totalTxt.setText("$" + total);
    }

    private void setupBottomNavigation() {
        FloatingActionButton cartButton = findViewById(R.id.cartbtn);
        LinearLayout homeButton = findViewById(R.id.homebtn);

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this, CartListActivity.class));
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this, MainActivity.class));
            }
        });
    }
}
