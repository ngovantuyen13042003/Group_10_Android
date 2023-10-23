package com.example.medicine;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class address extends AppCompatActivity {
    ImageView imvback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        imvback = findViewById(R.id.imvbackaddress);

        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(address.this, acccount.class));
            }
        });
        ListView listView= findViewById(R.id.list_address);
        ArrayList<address_item> address_i = new ArrayList<>();
        address_i.add(new address_item("495 Ngô Quyền, Sơn Trà, Đà Nẵng"));
        address_i.add(new address_item("05 Ngô Tất Tố, Hải Châu, Đà Nẵng"));
        address_i.add(new address_item("48 Cao Thắng, Hải Châu, Đà Nẵng"));
        address_i.add(new address_item("55 Lê Duẩn, Hải Châu, Đà Nẵng"));
        address_i.add(new address_item("95 Ngô Quyền, An Hải Bắc, Đà Nẵng"));

        customAdapterAddress adapter = new customAdapterAddress(this,address_i);
        listView.setAdapter(adapter);
    }
}