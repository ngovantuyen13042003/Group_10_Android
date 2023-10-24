package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

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

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom1);
        imageView= (ImageView) findViewById(R.id.imageview);

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
    }
}