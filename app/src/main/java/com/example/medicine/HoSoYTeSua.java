package com.example.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HoSoYTeSua extends AppCompatActivity {
    ImageView imgQuayLui;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ho_so_y_te_sua);


        imgQuayLui = findViewById(R.id.quay_lui);

        imgQuayLui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HoSoYTeSua.this, Ho_So_Y_Te.class);
                startActivity(intent);
            }
        });
    }
}
