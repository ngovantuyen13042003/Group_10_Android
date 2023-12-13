package com.example.medicine.interfaces;

import com.example.medicine.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountAPIservice {
    @POST("/api/user/login")
    Call<User> login(@Body User user);

    @POST("/api/user")
    Call<User> createUser(@Body User user);
}
