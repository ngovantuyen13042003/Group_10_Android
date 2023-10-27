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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class product extends AppCompatActivity {
    ImageView detail1,detail2,detail3,detail4,detail5,detail6,detail7,detail8, bannerproduct, giohang;
    TextView cart1,cart2,cart3,cart4,cart5,cart6,cart7,cart8;
    NavigationView navigationView;
    DrawerLayout drwproduct;
    Button btn_mua1,btn_mua2,btn_mua3,btn_mua4,btn_mua5,btn_mua6,btn_mua7,btn_mua8;
    ImageView  imvHome, imvProduct,imvDonHang, imvTinNhan, imvTaiKhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);
        detail1 = findViewById(R.id.productImage1);
        detail2 = findViewById(R.id.productImage2);
        detail3 = findViewById(R.id.productImage3);
        detail4 = findViewById(R.id.productImage4);
        detail5 = findViewById(R.id.productImage5);
        detail6 = findViewById(R.id.productImage6);
        detail7 = findViewById(R.id.productImage7);
        detail8 = findViewById(R.id.productImage8);
        bannerproduct= findViewById(R.id.banerproduct);
        cart1 = findViewById(R.id.cart1);
        cart2 = findViewById(R.id.cart2);
        cart3 = findViewById(R.id.cart3);
        cart4 = findViewById(R.id.cart4);
        cart5 = findViewById(R.id.cart5);
        cart6 = findViewById(R.id.cart6);
        cart7 = findViewById(R.id.cart7);
        cart8 = findViewById(R.id.cart8);
        drwproduct=findViewById(R.id.drawerproduct);
        navigationView = (NavigationView) findViewById(R.id.navigation);

        imvHome=findViewById(R.id.imvhome);
        imvProduct=findViewById(R.id.imvproduct);
        imvDonHang=findViewById(R.id.imvdonhang);
        imvTinNhan=findViewById(R.id.imvtinnhan);
        imvTaiKhoan=findViewById(R.id.imvtaikhoan);

        giohang=findViewById(R.id.imvgiohang);
        cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, cart.class));
            }
        });

        cart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, cart.class));
            }
        });
        cart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, cart.class));
            }
        });
        cart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, cart.class));
            }
        });
        cart5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, cart.class));
            }
        });
        cart6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, cart.class));
            }
        });
        cart7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, cart.class));
            }
        });
        cart8.setOnClickListener(new View.OnClickListener() {
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
        detail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, product_detail.class));
            }
        });
        detail4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, product_detail.class));
            }
        });
        detail5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, product_detail.class));
            }
        });
        detail6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, product_detail.class));
            }
        });
        detail7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, product_detail.class));
            }
        });
        detail8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, product_detail.class));
            }
        });
        giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, cart.class));
            }
        });
        bannerproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               drwproduct.openDrawer(GravityCompat.START);
            }
        });

//        btn_mua1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(product.this, cart.class));
//            }
//        });
//
//        btn_mua2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(product.this, cart.class));
//            }
//        });
//        btn_mua3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(product.this, signin.class));
//            }
//        });
//        btn_mua4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(product.this, signin.class));
//            }
//        });
//        btn_mua5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(product.this, signin.class));
//            }
//        });
//        btn_mua6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(product.this, signin.class));
//            }
//        });
//        btn_mua7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(product.this, signin.class));
//            }
//        });
//        btn_mua8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(product.this, signin.class));
//            }
//        });









        imvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, Home.class));
            }
        });
        imvTinNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, tin_nhan.class));
            }
        });
        imvProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, product.class));
            }
        });
        imvDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, MainActivity.class));
            }
        });
        imvTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(product.this, acccount.class));
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



    }
}