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
    NavigationView navigationView;
    ImageView cart1, banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);


        navigationView = (NavigationView) findViewById(R.id.navigationdetail);

        tvQuantity = findViewById(R.id.tvQuantity);
        Button btnDecrease = findViewById(R.id.btnDecrease);
        Button btnIncrease = findViewById(R.id.btnIncrease);
        back = findViewById(R.id.back_product);


        cart1 = findViewById(R.id.cart_detail);
        banner=findViewById(R.id.imvbannerdetail);
        dr=findViewById(R.id.drwproductdetail);

        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dr.openDrawer(GravityCompat.START);
            }
        });

        Menu menu = navigationView.getMenu();

        // Lặp qua các mục menu và đổi màu biểu tượng
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);


            // Lấy biểu tượng của mục
            Drawable icon = menuItem.getIcon();

            // Đổi màu biểu tượng
            if (icon != null) {
                icon.mutate(); // Để tránh tác động đến biểu tượng gốc
                icon.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.chudao), PorterDuff.Mode.SRC_IN);

                // Cập nhật lại biểu tượng trong Navigation View
                menuItem.setIcon(icon);
            }
        }
        cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product_detail.this, cart.class));
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