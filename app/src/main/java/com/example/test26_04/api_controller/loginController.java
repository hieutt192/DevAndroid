package com.example.test26_04.api_controller;

import android.util.Log;

import com.example.test26_04.models.LoginBody;
import com.example.test26_04.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

public interface loginController {

    static String API_BASE_URL = "http://192.168.181.1:5000/api/v1/";

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    loginController apiService = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(loginController.class);

    @POST("authentication/login")
    Call<LoginBody> login(@Body User user);

    @POST("authentication/signup")
    Call<String> signup(@Body User user);
}
