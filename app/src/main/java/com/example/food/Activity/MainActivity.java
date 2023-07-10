package com.example.food.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.food.Domain.Adapter.CategoryAdaptor;
import com.example.food.Domain.Adapter.PoplurarAdaptor;
import com.example.food.Domain.CategoryDomain;
import com.example.food.Domain.FoodDomain;
import com.example.food.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView reacViewCategortList,recyclerViewPopularlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recylerViewCategorry();
        recyclerViewPopular();
        botomNavigation();
    }
    private void botomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartbtn);
        LinearLayout homeBt =findViewById(R.id.homebtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));

            }
        });
        homeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });
    }
    private void recylerViewCategorry() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        reacViewCategortList=findViewById(R.id.recyclerView);
        reacViewCategortList.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("sua con bo","cat_1"));
        category.add(new CategoryDomain("sua con cho","cat_2"));
        category.add(new CategoryDomain("sua con meo","cat_3"));
        category.add(new CategoryDomain("sua con lon","cat_4"));
        category.add(new CategoryDomain("sua con heo","cat_5"));
        adapter=new CategoryAdaptor(category);
        reacViewCategortList.setAdapter(adapter);
    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularlist=findViewById(R.id.recyclerView2);
        recyclerViewPopularlist.setLayoutManager(linearLayoutManager);


        ArrayList<FoodDomain> foodlist=new ArrayList<>();
        foodlist.add(new FoodDomain("pep piza ","pizza1","pizaaa",9.76));
        foodlist.add(new FoodDomain("abc","bcv","asd",9.3));
        foodlist.add(new FoodDomain("abc","bcv","asd",9.3));
        foodlist.add(new FoodDomain("abc","bcv","asd",9.3));
        adapter2=new PoplurarAdaptor(foodlist);
        recyclerViewPopularlist.setAdapter(adapter2);
    }
}