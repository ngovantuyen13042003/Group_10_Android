package com.example.medicine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medicine.interfaces.AccountAPIservice;
import com.example.medicine.interfaces.AccountAPIservice;
import com.example.medicine.model.User;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class signup extends AppCompatActivity {

    EditText usertxt, passtxt,confimtxt;
    TextView  lk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        AnhXa();

        lk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup.this, signin.class));
            }
        });
    }
    private void AnhXa(){
        usertxt=findViewById(R.id.txt_username);
        passtxt= findViewById(R.id.edt_password);
        confimtxt=findViewById(R.id.edt_passwordConfirm);
        lk = findViewById(R.id.lksignin);

    }
    public void SigupClicked(View view){
        String email = usertxt.getText().toString();
        String password = passtxt.getText().toString();
        String confim = confimtxt.getText().toString();

        if(email.isEmpty() || password.isEmpty() || confim.isEmpty()){
            Toast.makeText(signup.this,"Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
        }
        if (password.equals(confim) == false){
            Toast.makeText(signup.this, "Mật khẩu không trùng khớp!",Toast.LENGTH_SHORT).show();
        }else {
            // tao mot Retrofit instance
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.56.1:8080")  //http://192.168.56.1:8080  https://medicine-w344.onrender.com
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder().build())
                    .build();
            // tao doi tuong User
            User user =  new User();
            user.setEmail(email);
            user.setPassword(password);
            // Tao mot interface de post
            AccountAPIservice service = retrofit.create(AccountAPIservice.class);
            // gui yeu cau dang ky
            Call<User> call = service.createUser(user);

            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()){
                        // dang nhap thanh cong
                        //User user1 = response.body();
                        Toast.makeText(signup.this, "Đăng ký thành công !", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signup.this, signin.class));
                    }else {
                        Toast.makeText(signup.this, "Đăng ký thất bại !", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(signup.this, "Lỗi sigup" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    t.printStackTrace(); // Log stack trace của lỗi
                }
            });
        }
    }
}















