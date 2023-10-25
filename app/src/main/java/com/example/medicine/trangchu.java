package com.example.medicine;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class trangchu extends AppCompatActivity {
    private BottomNavigationView mNavigationvew;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.trangchu));


        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_product);
        mViewPager=findViewById(R.id.view_pager);
        setUpViewPager();

        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            Intent intent = null;
            item.setChecked(true);
            switch (item.getItemId()) {
                case R.id.home:
                   mViewPager.setCurrentItem(0);
                   break;
                case R.id.product:
                    mViewPager.setCurrentItem(1);
                    break;
                case R.id.donhang:
                    mViewPager.setCurrentItem(2);
                    break;
                case R.id.chat:
                    mViewPager.setCurrentItem(3);
                    break;
                case R.id.account:
                    mViewPager.setCurrentItem(4);
                    break;

            }
            return true;
        });

    }
    private  void   setUpViewPager(){
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);
    }

}
