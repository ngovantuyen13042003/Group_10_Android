package com.example.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class themsanpham  extends AppCompatActivity {
    ImageView backadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_themsanpham);
        AnhXa();
        backadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(themsanpham.this, list_product_admin.class));
            }
        });
    }
    private void AnhXa(){
        backadmin=findViewById(R.id.imvbackadmin);
    }
}
