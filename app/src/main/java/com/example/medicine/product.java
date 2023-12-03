package com.example.medicine;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.medicine.adapter.ProductAdapter;
import com.example.medicine.api.ApiLaySp;
import com.example.medicine.interfaces.LaySPVe;
import com.example.medicine.object.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class product extends AppCompatActivity implements LaySPVe {
   ImageView detail1,detail2,detail3,detail4,detail5,detail6,detail7,detail8, bannerproduct, giohang;
    TextView cart1,cart2,cart3,cart4,cart5,cart6,cart7,cart8;
    NavigationView navigationView;
    DrawerLayout drwproduct;
    Button btn_mua1,btn_mua2,btn_mua3,btn_mua4,btn_mua5,btn_mua6,btn_mua7,btn_mua8;
    ImageView  imvHome, imvProduct,imvDonHang, imvTinNhan, imvTaiKhoan;
    GridView gvdsProduct;
    ProductAdapter adapter;
    ArrayList<Product> productArrayList;
    EditText editimkiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);
        init();
        anhXa();
        setup();
        setClick();
        new ApiLaySp(this).execute();

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








//
//        Menu menu = navigationView.getMenu();
//
//        // Lặp qua các mục menu và đổi màu biểu tượng
//        for (int i = 0; i < menu.size(); i++) {
//            MenuItem menuItem = menu.getItem(i);
//
//
//            // Lấy biểu tượng của mục
//            Drawable icon = menuItem.getIcon();
//
//            // Đổi màu biểu tượng
//            if (icon != null) {
//                icon.mutate(); // Để tránh tác động đến biểu tượng gốc
//                icon.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.chudao), PorterDuff.Mode.SRC_IN);
//
//                // Cập nhật lại biểu tượng trong Navigation View
//                menuItem.setIcon(icon);
//            }
//        }


    }

   private void  init(){
        productArrayList = new ArrayList<>();
        productArrayList.add(new Product("Thuốc hạ sốt ute",100000,"Hạ sốt nhanh","https://baobihoanggia.com/wp-content/uploads/2023/06/in-hop-thuoc-tay-3-1.jpg"));
//        productArrayList.add(new Product("Bao cao su",100000,"Hạ sốt nhanh","https://baobihoanggia.com/wp-content/uploads/2023/06/in-hop-thuoc-tay-3-1.jpg"));
//        productArrayList.add(new Product("Thuốc hạ sốt ute",100000,"Hạ sốt nhanh","https://baobihoanggia.com/wp-content/uploads/2023/06/in-hop-thuoc-tay-3-1.jpg"));
//        productArrayList.add(new Product("Thuốc hạ sốt ute",100000,"Hạ sốt nhanh","https://baobihoanggia.com/wp-content/uploads/2023/06/in-hop-thuoc-tay-3-1.jpg"));
        adapter=new ProductAdapter(this,0,productArrayList);
   }
   private void setup(){
        gvdsProduct.setAdapter(adapter);
   }
    private void anhXa(){
        gvdsProduct=findViewById(R.id.grvProduct);
        drwproduct=findViewById(R.id.drawerproduct);
        navigationView = (NavigationView) findViewById(R.id.navigation);

        imvHome=findViewById(R.id.imvhome);
        imvProduct=findViewById(R.id.imvproduct);
        imvDonHang=findViewById(R.id.imvdonhang);
        imvTinNhan=findViewById(R.id.imvtinnhan);
        imvTaiKhoan=findViewById(R.id.imvtaikhoan);
        giohang=findViewById(R.id.imvgiohang);
        bannerproduct= findViewById(R.id.banerproduct);
        editimkiem=findViewById(R.id.editexttk);
    }
    private void setClick(){
        editimkiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String p = editimkiem.getText().toString();
                adapter.sortProduct(p);
            }
        });
    }

    @Override
    public void BatDau() {
        Toast.makeText(this,"Dang tai", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void KetThuc(String data) {
        try {
            productArrayList.clear();
            JSONArray arr = new JSONArray(data);
            for (int i=0; i<arr.length();i++){
                JSONObject o =arr.getJSONObject(i);
                productArrayList.add(new Product(o));
            }
            adapter=new ProductAdapter(this,0,productArrayList);
            gvdsProduct.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }catch (JSONException e){
            e.printStackTrace(); // In thông tin lỗi để biết lý do xảy ra vấn đề
            Toast.makeText(this, "Lỗi xảy ra khi xử lý dữ liệu JSON", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void BiLoi() {
        Toast.makeText(this,"Bi loi ne", Toast.LENGTH_SHORT).show();
    }
}