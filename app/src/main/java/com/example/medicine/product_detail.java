package com.example.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.example.medicine.object.Product;

import java.util.ArrayList;


public class product_detail extends AppCompatActivity {
    private int quantity = 0;
    private TextView tvQuantity, back;
    DrawerLayout dr;
    ImageView cart1, imvsp;
    Button btn_buy,btnDecrease,btnIncrease;

    TextView productDetailTitle,price,des,dm;
    ArrayList<Product> productArrayList;

    String api;
    int productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        AnhXa();
        cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product_detail.this, cart.class));
            }
        });
//        btn_buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(product_detail.this, signin.class));
//            }
//        });

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
        // nhan id sanpham tu intent
//        try {
//            Intent intent = getIntent();
//            if(intent != null){
//                Product product = (Product) intent.getSerializableExtra("product");
//                TextView txtName = findViewById(R.id.productDetailTitle);
//                txtName.setText(product.getName());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        // Lấy thông tin tên sản phẩm từ Intent
        Intent intent = getIntent();
        if (intent != null) {
            String productName = intent.getStringExtra("productName");
            double productprice = intent.getDoubleExtra("price",-1);
            String productdsription = intent.getStringExtra("description");
            String image = intent.getStringExtra("img");
            int danhmuc = intent.getIntExtra("danhmuc", 0);
            if (productName != null) {
                productDetailTitle.setText(productName);
                String privetxt = String.valueOf(productprice);
                price.setText(privetxt + " vnd");
                des.setText(productdsription);
                Glide.with(this)
                        .load(image)
                        .into(imvsp);
                if (danhmuc == 1){
                    dm.setText("Thuốc Tây");
                }

            }
        }

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

    private void AnhXa(){
        tvQuantity = findViewById(R.id.tvQuantity);
        btnDecrease = findViewById(R.id.btnDecrease);
        btnIncrease = findViewById(R.id.btnIncrease);
        back = findViewById(R.id.back_product);


        cart1 = findViewById(R.id.cart_detail);
        btn_buy = findViewById(R.id.btn_buy);
        dr=findViewById(R.id.drwproductdetail);

        productDetailTitle = findViewById(R.id.productDetailTitle);
        price = findViewById(R.id.productPrice);
        des = findViewById(R.id.productDescription);
        imvsp = findViewById(R.id.img_product_detail);
        dm = findViewById(R.id.productDM);
    }


}