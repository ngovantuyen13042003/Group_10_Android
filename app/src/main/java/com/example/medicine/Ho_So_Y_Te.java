package com.example.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Ho_So_Y_Te extends AppCompatActivity {

    Button btnSua;
    ImageView quaylui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ho_so_y_te);

        btnSua = (Button) findViewById(R.id.sua);
        quaylui= findViewById(R.id.quay_lui);

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ho_So_Y_Te.this, HoSoYTeSua.class);
                startActivity(intent);
            }
        });
        quaylui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ho_So_Y_Te.this, acccount.class);
                startActivity(intent);
            }
        });

    }
}
