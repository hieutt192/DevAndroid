package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.test26_04.api_controller.productAPI;
import com.example.test26_04.models.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnProduct ;
    private ImageButton btnStatictic ;
    private ImageButton btnOrder ;
    private ImageButton btnStorage ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProduct = findViewById(R.id.btn_product);
        btnOrder = findViewById(R.id.btn_order);
        btnStorage = findViewById(R.id.btn_storage);
        btnStatictic = findViewById(R.id.btn_statictic);


        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callGetAllProductsAPI(ProductActivity.class);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),OrderActivity.class));

            }
        });

        btnStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callGetAllProductsAPI(StorageActivity.class);
            }
        });
    }

    private void callGetAllProductsAPI(Class destination){
        productAPI.apiService.getAllProducts().enqueue(new Callback<ArrayList<Product>>() {

            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                ArrayList<Product> res = response.body();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, destination);
                intent.putExtra("Product list", res);
                startActivity(intent);
            }


            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Can not call API", Toast.LENGTH_SHORT).show();
            }
        });
    }
}