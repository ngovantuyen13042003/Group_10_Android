package com.example.medicine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicine.api.AppApi;
import com.example.medicine.interfaces.AccountAPIservice;
import com.example.medicine.interfaces.AccountAPIservice;
import com.example.medicine.model.User;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class signin extends AppCompatActivity {
    TextView lk,forgetpassword;

    EditText edtemail, edtpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        AnhXa();

        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signin.this, com.example.medicine.forgetpassword.class));
            }
        });

        lk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signin.this, signup.class));
            }
        });
    }
    private void  AnhXa(){
        lk = findViewById(R.id.lksignup);
        forgetpassword = findViewById(R.id.forgetpass);
        edtemail = findViewById(R.id.txt_username);
        edtpass = findViewById(R.id.txt_password);
    }
    public void loginClicked(View view){
        edtemail = findViewById(R.id.txt_username);
        edtpass = findViewById(R.id.txt_password);

        String email = edtemail.getText().toString();
        String password = edtpass.getText().toString();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(signin.this,"Vui lòng nhập đầy đủ thông tin !", Toast.LENGTH_SHORT).show();
        }else {
            // tao mot Retrofit instance
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(AppApi.BASE_URL)  //http://192.168.56.1:8080  https://medicine-w344.onrender.com
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            // Tao mot interface de post
            AccountAPIservice service = retrofit.create(AccountAPIservice.class);

            // tao doi tuong User
            User user =  new User();
            user.setEmail(email);
            user.setPassword(password);

            // gui yeu cau dang nhap
            Call<User> call = service.login(user);

            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()){
                        // dang nhap thanh cong
                        User user1 = response.body();
                        SharedPreferences sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        Gson gson = new Gson();
                        String userJson = gson.toJson(user1);
                        editor.putString("user_object", userJson);
                        editor.apply();
                        // chuyen sang home
                        Intent intent = new Intent(signin.this, Home.class);
                        startActivity(intent);
                        finish(); // ngan quay lai dang nhap
                    }else {
                        Toast.makeText(signin.this, "Email hoặc mật khẩu không đúng !", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(signin.this, "Lỗi " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }




    }
}