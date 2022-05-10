package com.example.test26_04.api_controller;

import com.example.test26_04.models.AllProductResponse;
import com.example.test26_04.models.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface productAPI {

    static String API_BASE_URL = "http://192.168.181.1:5000/api/v1/products/";

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    productAPI apiService = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(productAPI.class);

    @GET("all-products")
    Call<ArrayList<Product>> getAllProducts();


}
