package com.example.medicine.api;

import com.example.medicine.model.MyCartModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CartAPI {

    @POST("api/cart")
    Call<MyCartModel> addToCart(@Body MyCartModel myCartModel);

    @GET("/api/cart/{idUser}")
    Call<List<MyCartModel>> getAllCartByUserId(@Path(("idUser")) Integer idUser);


    @DELETE("/api/cart/{idCart}")
    Call<Void> deleteCartItem(@Path("idCart") Integer idCart);

}
