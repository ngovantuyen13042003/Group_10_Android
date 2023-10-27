package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;

    ImageView  imvHome, imvProduct,imvDonHang, imvTinNhan, imvTaiKhoan;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navigationView = (NavigationView) findViewById(R.id.navigation);
//        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_home);
        imageView= (ImageView) findViewById(R.id.imageview);

        imvHome=findViewById(R.id.imvhome);
        imvProduct=findViewById(R.id.imvproduct);
        imvDonHang=findViewById(R.id.imvdonhang);
        imvTinNhan=findViewById(R.id.imvtinnhan);
        imvTaiKhoan=findViewById(R.id.imvtaikhoan);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        // Lấy menu của Navigation View
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
        imvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Home.class));
            }
        });
        imvTinNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, tin_nhan.class));
            }
        });
        imvProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, product.class));
            }
        });
        imvDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, MainActivity.class));
            }
        });
        imvTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, acccount.class));
            }
        });
//        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_home);
//        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
//            Intent intent = null;
//
//            switch (item.getItemId()) {
//                case R.id.home:
//                    // Chuyển đến màn hình trang chủ (HomeActivity)
//                    intent = new Intent(this, Home.class);
//                    break;
//                case R.id.product:
//                    // Chuyển đến màn hình sản phẩm (ProductActivity)
//                    intent = new Intent(this, product.class);
//                    break;
//                case R.id.donhang:
//                    // Chuyển đến màn hình đơn hàng (DonHangActivity)
//                    intent = new Intent(this, MainActivity.class);
//                    break;
//                case R.id.chat:
//                    // Chuyển đến màn hình chat (ChatActivity)
//                    intent = new Intent(this, tin_nhan.class);
//                    break;
//                case R.id.account:
//                    // Chuyển đến màn hình tài khoản (AccountActivity)
//                    intent = new Intent(this, acccount.class);
//                    break;
//                default:
//                    intent = null;
//            }
//
//            if (intent != null) {
//                startActivity(intent);
//            }
//
//            return true;
//        });
    }
}