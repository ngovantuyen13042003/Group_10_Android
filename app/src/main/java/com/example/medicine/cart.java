package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
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
    private TextView back;

    ListView listViewcart;

    private CartAdapter cartAdapter;

    private ArrayList<Product> cartproductlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        btn_buy_cart = findViewById(R.id.btn_buy_cart);
        btn_change = findViewById(R.id.btn_change);
        back = findViewById(R.id.back_product);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cart.this, address.class));
            }
        });


        listViewcart = findViewById(R.id.listViewCart);

        // lay data tu SharedPerences
        updateCartProductListFromSharedPreferences();
        cartAdapter = new CartAdapter(cart.this, 0, cartproductlist);
        cartAdapter.setOnDeleteButtonClickListener(new CartAdapter.OnDeleteButtonClickListener() {
            @Override
            public void onDeleteButtonClick(Product product) {
                AlertDialog.Builder builder = new AlertDialog.Builder(cart.this);
                builder.setMessage("Bạn có muốn xóa sản phẩm này không?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Xóa sản phẩm khỏi danh sách và cập nhật SharedPreferences
                                SharedPreferences sharedPreferences = getSharedPreferences("product_data", Context.MODE_PRIVATE);
                                Set<String> productSet = sharedPreferences.getStringSet("product_set", new HashSet<>());

                                Gson gson = new Gson();
                                String productJson = gson.toJson(product);
                                productSet.remove(productJson);

                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putStringSet("product_set", productSet);
                                editor.apply();

                                // Xóa sản phẩm khỏi danh sách hiển thị
                                cartproductlist.remove(product);
                                cartAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss(); // Đóng dialog nếu không muốn xóa
                            }
                        })
                        .show();
            }
        });
        listViewcart.setAdapter(cartAdapter);

        btn_buy_cart.setOnClickListener(v -> buyCheckedProducts());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(cart.this, product.class));
            }
        });
    }
    private void updateCartProductListFromSharedPreferences() {
        cartproductlist = new ArrayList<>();

        // Lấy danh sách sản phẩm từ SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("product_data", Context.MODE_PRIVATE);
        Set<String> productSet = sharedPreferences.getStringSet("product_set", new HashSet<>());

        // Chuyển đổi từ chuỗi JSON thành đối tượng Product
        Gson gson = new Gson();
        for (String productJson : productSet) {
            Product product = gson.fromJson(productJson, Product.class);
            cartproductlist.add(product);
        }
    }
    private void buyCheckedProducts() {
        SharedPreferences sharedPreferences = getSharedPreferences("product_data", Context.MODE_PRIVATE);
        Set<String> productSet = sharedPreferences.getStringSet("product_set", new HashSet<>());

        Iterator<Product> iterator = cartproductlist.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.isChecked() == true) {
                // Xóa sản phẩm khỏi danh sách SharedPreferences
                Gson gson = new Gson();
                String productJson = gson.toJson(product);
                productSet.remove(productJson);

                // Xóa sản phẩm khỏi danh sách hiển thị
                iterator.remove();
            }
        }

        // Cập nhật danh sách sản phẩm mới cho SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("product_set", productSet);
        editor.apply();
        editor.clear();
        cartAdapter.notifyDataSetChanged();
    }

}