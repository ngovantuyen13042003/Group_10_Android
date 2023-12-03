package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.medicine.adapter.CartAdapter;
import com.example.medicine.adapter.ProductAdapter;
import com.example.medicine.object.Product;
import com.example.medicine.object.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class cart extends AppCompatActivity {
    private int quantity = 0, quantity1 = 0;
    Button btn_buy_cart,btn_change;
    private TextView tvQuantity,tvQuantity1, back;

    ListView listViewcart;

    private CartAdapter cartAdapter;

    private ArrayList<Product> cartproductlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        btn_buy_cart = findViewById(R.id.btn_buy_cart);
        btn_change = findViewById(R.id.btn_change);
//        tvQuantity = findViewById(R.id.tvQuantity);
//        tvQuantity1 = findViewById(R.id.tvQuantity1);
//        Button btnDecrease = findViewById(R.id.btnDecrease);
//        Button btnIncrease = findViewById(R.id.btnIncrease);
//        Button btnDecrease1 = findViewById(R.id.btnDecrease1);
//        Button btnIncrease1 = findViewById(R.id.btnIncrease1);
        back = findViewById(R.id.back_product);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cart.this, address.class));
            }
        });
//        btn_buy_cart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(cart.this, signin.class));
//            }
//        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cart.this, product.class));
            }
        });

//        btnDecrease.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                decreaseQuantity();
//            }
//        });
//
//        btnIncrease.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                increaseQuantity();
//            }
//        });
//
//        btnDecrease1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                decreaseQuantity1();
//            }
//        });
//
//        btnIncrease1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                increaseQuantity1();
//            }
//        });

        listViewcart = findViewById(R.id.listViewCart);
        cartproductlist = new ArrayList<>();
//        cartproductlist.add(new Product("Thuốc sổ", 5000,1,"https://baobihoanggia.com/wp-content/uploads/2023/06/in-hop-thuoc-tay-3-1.jpg"));
//        cartproductlist.add(new Product("Thuốc sổ", 5000,1,"https://baobihoanggia.com/wp-content/uploads/2023/06/in-hop-thuoc-tay-3-1.jpg"));
//        cartproductlist.add(new Product("Thuốc sổ", 5000,1,"https://baobihoanggia.com/wp-content/uploads/2023/06/in-hop-thuoc-tay-3-1.jpg"));
//        cartproductlist.add(new Product("Thuốc sổ", 5000,1,"https://baobihoanggia.com/wp-content/uploads/2023/06/in-hop-thuoc-tay-3-1.jpg"));
//        Intent intent = getIntent();
//        if (intent != null){
//            String name = intent.getStringExtra("name");
//            double price = intent.getDoubleExtra("price",-1);
//            int dm = intent.getIntExtra("dm",1);
//            String img = intent.getStringExtra("img");
//            cartproductlist.add(new Product(name,price,img));
//        }
//        cartproductlist.clear();
        SharedPreferences sharedPreferences = getSharedPreferences("product_data", Context.MODE_PRIVATE);
        // Đọc danh sách sản phẩm từ SharedPreferences
        Set<String> productSet = sharedPreferences.getStringSet("product_set", new HashSet<>());
        // Duyệt qua danh sách và chuyển đổi từ chuỗi JSON thành đối tượng Product
        Product product = null;
        for (String productJson : productSet) {
            Gson gson = new Gson();
            product = gson.fromJson(productJson, Product.class);
//            cartproductlist.add(product);
            String name = product.getName();
            double price = product.getPrice();
            String img = product.getImage();
            cartproductlist.add(new Product(name, price, img));
        }
        cartAdapter = new CartAdapter(cart.this, 0, cartproductlist);
        listViewcart.setAdapter(cartAdapter);

        btn_buy_cart.setOnClickListener(v -> buyCheckedProducts());

    }
    private void buyCheckedProducts (){
        Iterator<Product> iterator = cartproductlist.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.isChecked()) {
                iterator.remove();
            }
        }
        saveProductsToSharedPreferences(cartproductlist);
        cartAdapter.notifyDataSetChanged();
    }
    private void saveProductsToSharedPreferences(ArrayList<Product> products) {
        SharedPreferences sharedPreferences = getSharedPreferences("product_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        // Chuyển danh sách sản phẩm thành chuỗi JSON
        String productsJson = gson.toJson(products);

        editor.putString("product_list", productsJson);
        editor.apply();
    }



//    private void decreaseQuantity() {
//        if (quantity > 0) {
//            quantity--;
//            updateQuantityText();
//        }
//    }
//
//    private void increaseQuantity() {
//        quantity++;
//        updateQuantityText();
//    }
//
//    private void updateQuantityText() {
//        tvQuantity.setText(String.valueOf(quantity));
//    }
//
//// product 2
//    private void decreaseQuantity1() {
//        if (quantity1 > 0) {
//            quantity1--;
//            updateQuantityText1();
//        }
//    }
//
//    private void increaseQuantity1() {
//        quantity1++;
//        updateQuantityText1();
//    }
//
//    private void updateQuantityText1() {
//        tvQuantity1.setText(String.valueOf(quantity1));
//    }
}