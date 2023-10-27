package com.example.medicine;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class product_detail extends AppCompatActivity {
    private int quantity = 0;
    private TextView tvQuantity, back;
    DrawerLayout dr;
    ImageView cart1;
    Button btn_buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);



        tvQuantity = findViewById(R.id.tvQuantity);
        Button btnDecrease = findViewById(R.id.btnDecrease);
        Button btnIncrease = findViewById(R.id.btnIncrease);
        back = findViewById(R.id.back_product);


        cart1 = findViewById(R.id.cart_detail);
        btn_buy = findViewById(R.id.btn_buy);
        dr=findViewById(R.id.drwproductdetail);


        cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product_detail.this, cart.class));
            }
        });
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product_detail.this, signin.class));
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product_detail.this, product.class));
            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseQuantity();
            }
        });

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseQuantity();
            }
        });
    }

    private void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
            updateQuantityText();
        }
    }

    private void increaseQuantity() {
        quantity++;
        updateQuantityText();
    }

    private void updateQuantityText() {
        tvQuantity.setText(String.valueOf(quantity));
    }

}