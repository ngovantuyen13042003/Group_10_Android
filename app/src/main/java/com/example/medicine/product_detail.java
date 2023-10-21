package com.example.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class product_detail extends AppCompatActivity {
    private int quantity = 0;
    private TextView tvQuantity, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ImageView imageView = findViewById(R.id.cart);
        imageView.getLayoutParams().width = 50; // Chiều rộng
        imageView.getLayoutParams().height = 50; // Chiều cao
        tvQuantity = findViewById(R.id.tvQuantity);
        Button btnDecrease = findViewById(R.id.btnDecrease);
        Button btnIncrease = findViewById(R.id.btnIncrease);
        back = findViewById(R.id.back_product);

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