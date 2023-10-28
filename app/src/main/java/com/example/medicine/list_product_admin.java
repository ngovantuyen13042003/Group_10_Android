package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class list_product_admin extends AppCompatActivity {
    ImageView imvAddproduct, back;
    LinearLayout product1,product2,product3,product4,product5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product_admin);

        AnhXa();
        imvAddproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(list_product_admin.this, themsanpham.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(list_product_admin.this, acccount.class));
            }
        });
        product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(list_product_admin.this, capnhatsanpham.class));
            }
        });
        product2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(list_product_admin.this, capnhatsanpham.class));
            }
        });
        product3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(list_product_admin.this, capnhatsanpham.class));
            }
        });
        product4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(list_product_admin.this, capnhatsanpham.class));
            }
        });
        product5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(list_product_admin.this, capnhatsanpham.class));
            }
        });




    }
    private void  AnhXa(){
        imvAddproduct=findViewById(R.id.add_product);
        back=findViewById(R.id.imvbackaccount);

        product1=findViewById(R.id.L_product1);
        product2=findViewById(R.id.L_product2);
        product3=findViewById(R.id.L_product3);
        product4=findViewById(R.id.L_product4);
        product5=findViewById(R.id.L_product5);
    }
}