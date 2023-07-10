package com.example.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.food.Activity.MainActivity;

public class IntroActivity extends AppCompatActivity {
    private ConstraintLayout startbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbtn=findViewById(R.id.startbtn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });
    }
}