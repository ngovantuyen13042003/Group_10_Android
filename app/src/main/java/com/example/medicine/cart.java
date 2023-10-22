package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class cart extends AppCompatActivity {
    private int quantity = 0;
    private TextView tvQuantity, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        tvQuantity = findViewById(R.id.tvQuantity);
        Button btnDecrease = findViewById(R.id.btnDecrease);
        Button btnIncrease = findViewById(R.id.btnIncrease);
        back = findViewById(R.id.back_product);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cart.this, product.class));
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