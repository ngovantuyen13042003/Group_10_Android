package com.example.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
public class tin_nhan extends AppCompatActivity  {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ViewPager pager;
    TabLayout tabLayout;
    TabItem dxlItem,historyItem;

    PagerAdapter_sy adapter;

    ImageView  imvHome, imvProduct,imvDonHang, imvTinNhan, imvTaiKhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinnhan);

        Toolbar toolbar=findViewById(R.id.mtoolbar);
        setSupportActionBar(toolbar);

        pager=findViewById(R.id.mviewpagertn);
        tabLayout=findViewById(R.id.mtablayout);
        dxlItem=findViewById(R.id.tabNhaThuoc);
        historyItem=findViewById(R.id.tabBacSi);

        drawerLayout=findViewById(R.id.mdrawer);
        navigationView=findViewById(R.id.mna_view);

        imvHome=findViewById(R.id.imvhome);
        imvProduct=findViewById(R.id.imvproduct);
        imvDonHang=findViewById(R.id.imvdonhang);
        imvTinNhan=findViewById(R.id.imvtinnhan);
        imvTaiKhoan=findViewById(R.id.imvtaikhoan);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        adapter= new PagerAdapter_sy(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount());
        pager.setAdapter(adapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        imvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tin_nhan.this, Home.class));
            }
        });
        imvTinNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tin_nhan.this, tin_nhan.class));
            }
        });
        imvProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tin_nhan.this, product.class));
            }
        });
        imvDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tin_nhan.this, MainActivity.class));
            }
        });
        imvTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tin_nhan.this, acccount.class));
            }
        });



//        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_chat);
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
