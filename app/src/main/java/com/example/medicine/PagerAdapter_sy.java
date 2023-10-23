package com.example.medicine;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter_sy extends FragmentPagerAdapter {

    private int tabsNumber;
    public PagerAdapter_sy(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabsNumber=tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fragment_nah_thuoc();
            case 1 :
                return new Fragment_bac_si();
            default:
                return new Fragment_nah_thuoc();
        }



    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
