package com.example.medicine;

import static android.app.PendingIntent.getActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.medicine.model.User;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import android.content.SharedPreferences;

public class acccount extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ImageView imvaccountsetting, imvhosoyte,imvHome, imvProduct,imvDonHang, imvTinNhan, imvTaiKhoan;
    RelativeLayout layoutHosoyte,LayoutAuthor,LayoutAdmin;
    LinearLayout layoutAddress, LayoutLogout;
    TextView saveaddress,username,phonenum;
    ImageButton btngiohang;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        AnhXa();

        SharedPreferences sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String userJson = sharedPreferences.getString("user_object", "");

        Gson gson = new Gson();
        User user = gson.fromJson(userJson, User.class);

        username.setText(user.getName());
        //phonenum.setText("+" + user.getPhone());


        setSupportActionBar(toolbar);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

//        set onclick cho caidattaikhoan
        imvaccountsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, accountsetting.class));
            }
        });
        layoutAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, address.class));
            }
        });
        layoutHosoyte.setOnClickListener(new View.OnClickListener() {
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

        LayoutAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, profile.class));
            }
        });
        LayoutAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(acccount.this, list_product_admin.class));
            }
        });
        LayoutLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo AlertDialog.Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(acccount.this);

                // Thiết lập thông điệp và tiêu đề
                builder.setMessage("Bạn có muốn đăng xuất?")
                        .setTitle("Xác nhận");

                // Thêm nút OK
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Xử lý khi người dùng click OK
                        // Thực hiện hành động tiếp theo ở đây
                        startActivity(new Intent(acccount.this, signin.class));
                        SharedPreferences sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        finish();
                        finishAffinity();
                    }
                });

                // Thêm nút Cancel
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Xử lý khi người dùng click Cancel
                        dialog.dismiss(); // Đóng dialog
                    }
                });

                // Hiển thị AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();
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
    private void AnhXa(){
        LayoutLogout = findViewById(R.id.btnLogout);
        username = findViewById(R.id.Usernameacccount);
        phonenum = findViewById(R.id.txtphone);
        toolbar=findViewById(R.id.mtoolbar);
        imvhosoyte=findViewById(R.id.imvHoSoyte);
        drawerLayout=findViewById(R.id.mdrawer);
        navigationView=findViewById(R.id.mna_view);
        imvHome=findViewById(R.id.imvhome);
        imvProduct=findViewById(R.id.imvproduct);
        imvDonHang=findViewById(R.id.imvdonhangacount);
        imvTinNhan=findViewById(R.id.imvtinnhan);
        imvTaiKhoan=findViewById(R.id.imvtaikhoan);

        layoutHosoyte=findViewById(R.id.hosoyteLayout);
        LayoutAuthor=findViewById(R.id.authorLayout);
        layoutAddress=findViewById(R.id.addressLayout);
        LayoutAdmin=findViewById(R.id.adminLayout);

        btngiohang=findViewById(R.id.iconButton);
        imvaccountsetting = findViewById(R.id.imvaccountsetting);
    }
}
