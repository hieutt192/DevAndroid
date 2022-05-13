package com.example.test26_04;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test26_04.api_controller.productAPI;
import com.example.test26_04.utils.ProductAdapter;
import com.example.test26_04.R;
import com.example.test26_04.models.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        rcvData = findViewById(R.id.rcv_data);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);

        Intent intent = getIntent();
        productList = (ArrayList<Product>) intent.getSerializableExtra("Product list");

        productAdapter = new ProductAdapter(this, productList, Detail_Product_Activity.class);
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
        Intent intent = getIntent();
        productList = (ArrayList<Product>) intent.getSerializableExtra("Product list");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ProductActivity.this, MainActivity.class);
        startActivity(intent);
    }


}