
package com.example.medicine;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentManager;
        import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private int tabsNumber;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new pageHome();
            case 1 :
                return new pageProduct();
            case 2 :
                return new pageDonHang();
            case 3 :
                return new pageTinNhan();
//            case 4 :
//                return new pageAccount();
            default:
                return new pageHome();
        }



    }

    @Override
    public int getCount() {
        return 5;
    }
}
