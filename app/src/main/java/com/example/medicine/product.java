package com.example.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class product extends AppCompatActivity {
    ImageView detail1, detail2;
    TextView cart1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);
        detail1 = findViewById(R.id.productImage);
        detail2 = findViewById(R.id.productImage2);
        cart1 = findViewById(R.id.cart);

        cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, cart.class));
            }
        });

        detail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, product_detail.class));
            }
        });

        detail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, product_detail.class));
            }
        });
    }
}