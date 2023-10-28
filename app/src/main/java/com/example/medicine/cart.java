package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class cart extends AppCompatActivity {
    private int quantity = 0, quantity1 = 0;
    Button btn_buy_cart,btn_change;
    private TextView tvQuantity,tvQuantity1, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        btn_buy_cart = findViewById(R.id.btn_buy_cart);
        btn_change = findViewById(R.id.btn_change);
        tvQuantity = findViewById(R.id.tvQuantity);
        tvQuantity1 = findViewById(R.id.tvQuantity1);
        Button btnDecrease = findViewById(R.id.btnDecrease);
        Button btnIncrease = findViewById(R.id.btnIncrease);
        Button btnDecrease1 = findViewById(R.id.btnDecrease1);
        Button btnIncrease1 = findViewById(R.id.btnIncrease1);
        back = findViewById(R.id.back_product);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cart.this, address.class));
            }
        });
        btn_buy_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cart.this, signin.class));
            }
        });

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

        btnDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseQuantity1();
            }
        });

        btnIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseQuantity1();
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

// product 2
    private void decreaseQuantity1() {
        if (quantity1 > 0) {
            quantity1--;
            updateQuantityText1();
        }
    }

    private void increaseQuantity1() {
        quantity1++;
        updateQuantityText1();
    }

    private void updateQuantityText1() {
        tvQuantity1.setText(String.valueOf(quantity1));
    }
}