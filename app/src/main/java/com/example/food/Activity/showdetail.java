package com.example.food.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.food.Domain.FoodDomain;
import com.example.food.Helper.ManagemenCart;
import com.example.food.Helper.TinyDB;
import com.example.food.R;

public class showdetail extends AppCompatActivity {
    private TextView addtocarbtn;
    private TextView titleTxt,feetxt,descriptionTxt,numberOrdertxt;
     private    ImageView plusBt,minsBtn,picFood;
     private FoodDomain object;
     int numberOrder=1;
     private ManagemenCart managemenCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdetail);

        managemenCart = new ManagemenCart(this, new TinyDB(getApplicationContext()));
        initView();
        getBundle();
    }

    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");
        if (object != null) {
            String picName = object.getPic();
            if (picName != null) {
                int drawableResourceId = getResources().getIdentifier(picName, "drawable", getPackageName());
                Glide.with(this)
                        .load(drawableResourceId)
                        .into(picFood);
            }

            titleTxt.setText(object.getTitle());
            feetxt.setText("$" + object.getFee());
            descriptionTxt.setText(object.getDescription());
            numberOrdertxt.setText(String.valueOf(numberOrder));
        }

        addtocarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberaIncart(numberOrder);
                managemenCart.insertFood(object);
            }
        });
        plusBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder=numberOrder+1;
                numberOrdertxt.setText(String.valueOf(numberOrder));
            }
        });
        minsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOrder >1){
                    numberOrder = numberOrder -1;
                }
                numberOrdertxt.setText(String.valueOf(numberOrder ));

            }
        });
        addtocarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberaIncart(numberOrder);
                managemenCart.insertFood(object);
            }
        });
    }

    private void initView() {
        addtocarbtn=findViewById(R.id.addTocartbtn);
        titleTxt=findViewById(R.id.titleTxtcart);
        feetxt=findViewById(R.id.priceTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOrdertxt=findViewById(R.id.numberorder);
        plusBt=findViewById(R.id.plusBtn);
        minsBtn=findViewById(R.id.minbtn);
        picFood=findViewById(R.id.picFood);
    }
}