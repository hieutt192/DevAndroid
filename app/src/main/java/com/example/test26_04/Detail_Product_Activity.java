package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.test26_04.R;
import com.example.test26_04.api_controller.productAPI;
import com.example.test26_04.models.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail_Product_Activity extends AppCompatActivity {

    private Button deleteBtn;
    private ArrayList<Product> updatedProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        deleteBtn = findViewById(R.id.btn_delete);

        Bundle bundle = getIntent().getExtras();

        if (bundle == null){
            return;
        }
        Product product = (Product) bundle.get("Object Product");

        TextView textView = findViewById(R.id.txt_Name_Product);
        textView.setText(product.getName());

        ImageView imageView = findViewById(R.id.img_Detail);
        Glide.with(this).load(product.getImage()).into(imageView);

        TextView priceView = findViewById(R.id.txt_Price_Product);
        priceView.setText(String.valueOf(product.getPrice()));

        TextView descriptionView = findViewById(R.id.txt_Description_Product);
        descriptionView.setText(product.getDescription());

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDeleteProductAPI(product.get_id());
            }
        });
    }

    private void callDeleteProductAPI(String _id){
        productAPI.apiService
                .deleteProduct(_id)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(Detail_Product_Activity.this, response.body(), Toast.LENGTH_SHORT).show();
                        productAPI.apiService
                                .getAllProducts()
                                .enqueue(new Callback<ArrayList<Product>>() {
                                    @Override
                                    public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                                        Intent intent = new Intent(Detail_Product_Activity.this, ProductActivity.class);
                                        intent.putExtra("Product list",response.body());
                                        startActivity(intent);

                                    }

                                    @Override
                                    public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

                                    }
                                });
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(Detail_Product_Activity.this, "Can not call API", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}