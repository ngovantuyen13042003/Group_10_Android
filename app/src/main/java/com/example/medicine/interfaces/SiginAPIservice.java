package com.example.medicine.interfaces;

import com.example.medicine.object.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SiginAPIservice {
    @POST("/api/user/login")
    Call<User> login(@Body User user);
}
