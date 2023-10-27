package com.example.medicine;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class accountsetting extends AppCompatActivity {
    ImageView imvback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsetting);
        imvback = findViewById(R.id.imvback);

        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(accountsetting.this, acccount.class));
            }
        });
    }
}
