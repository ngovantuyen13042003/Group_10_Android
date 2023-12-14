package com.example.medicine;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicine.model.User;
import com.google.gson.Gson;

public class accountsetting extends AppCompatActivity {
    private ImageView imvback;
    private TextView name, phone, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsetting);
        AnhXa();

        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(accountsetting.this, acccount.class));
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String userJson = sharedPreferences.getString("user_object", "");

        Gson gson = new Gson();
        User user = gson.fromJson(userJson, User.class);
        name.setText(user.getName());
        phone.setText(user.getPhone());
        email.setText(user.getEmail());
    }
    private void AnhXa(){
        imvback = findViewById(R.id.imvback);
        name = findViewById(R.id.stname);
        phone = findViewById(R.id.stsdt);
        email = findViewById(R.id.stemail);
    }
}
