package com.example.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class acccount extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ImageView imvaccountsetting, imvhosoyte,imvHome, imvProduct,imvDonHang, imvTinNhan, imvTaiKhoan;
    TextView saveaddress;
    ImageButton btngiohang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Toolbar toolbar=findViewById(R.id.mtoolbar);
        setSupportActionBar(toolbar);
        imvhosoyte=findViewById(R.id.imvHoSoyte);

        drawerLayout=findViewById(R.id.mdrawer);
        navigationView=findViewById(R.id.mna_view);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        imvHome=findViewById(R.id.imvhome);
        imvProduct=findViewById(R.id.imvproduct);
        imvDonHang=findViewById(R.id.imvdonhang);
        imvTinNhan=findViewById(R.id.imvtinnhan);
        imvTaiKhoan=findViewById(R.id.imvtaikhoan);

        btngiohang=findViewById(R.id.iconButton);

//        set onclick cho caidattaikhoan
        imvaccountsetting = findViewById(R.id.imvaccountsetting);
        imvaccountsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, accountsetting.class));
            }
        });
        saveaddress = findViewById(R.id.imvsaveaddress);
        saveaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, address.class));
            }
        });
        imvhosoyte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, Ho_So_Y_Te.class));
            }
        });
        imvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, Home.class));
            }
        });
        imvTinNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, tin_nhan.class));
            }
        });
        imvProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, product.class));
            }
        });
        imvDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, MainActivity.class));
            }
        });
        imvTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, acccount.class));
            }
        });
        btngiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, cart.class));
            }
        });


//        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_acc);
//        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
//            Intent intent = null;
//
//            switch (item.getItemId()) {
//                case R.id.home:
//                    // Chuyển đến màn hình trang chủ (HomeActivity)
//
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
