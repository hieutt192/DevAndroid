package com.example.test26_04;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test26_04.api_controller.productAPI;
import com.example.test26_04.utils.OrderItemViewModel;
import com.example.test26_04.utils.ProductAdapter;
import com.example.test26_04.R;
import com.example.test26_04.models.Product;
import com.example.test26_04.utils.ProductItemViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProductActivity extends AppCompatActivity {

    private RecyclerView rcvData;
    private ProductAdapter productAdapter;
    private FloatingActionButton btnAddP;
    private ArrayList<Product> productList;
    private ProductItemViewModel viewModel;
    private Gson gson = new Gson();
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        sp = getSharedPreferences("added product", Context.MODE_PRIVATE);
        rcvData = findViewById(R.id.rcv_data);
        viewModel = new  ViewModelProvider(this).get(ProductItemViewModel.class);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);

        Intent intent = getIntent();
        productList = (ArrayList<Product>) intent.getSerializableExtra("Product list");

        productAdapter = new ProductAdapter(this, productList, Detail_Product_Activity.class, viewModel);
        rcvData.setAdapter(productAdapter);

        btnAddP = findViewById(R.id.btnAddNewProduct);
        btnAddP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivity.this, Add_ProductActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        String json = sp.getString("added product", "");
        Product addedProduct = gson.fromJson(json, Product.class);
        Log.e("ADDED PRODUCT", json);
        productAdapter.addProduct(addedProduct);
    }
}