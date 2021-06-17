package com.example.ir.xtools.hadaf.hadafgozarinovin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class luncher extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luncher);
        button=findViewById(R.id.btnplus);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(luncher.this,MainActivity.class);//کلیک کردن برای صحه دیگه
                startActivity(intent);
            }
        });
    }



}