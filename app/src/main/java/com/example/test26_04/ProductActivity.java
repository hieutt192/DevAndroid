package com.example.test26_04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test26_04.utils.ProductAdapter;
import com.example.test26_04.R;
import com.example.test26_04.models.Product;


import java.util.ArrayList;
import java.util.List;


public class ProductActivity extends AppCompatActivity {

    private RecyclerView rcvData;
    private ProductAdapter productAdapter;

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
        ArrayList<Product> productList = (ArrayList<Product>) intent.getSerializableExtra("Product list");

        productAdapter = new ProductAdapter(this, productList, Detail_Product_Activity.class);
        rcvData.setAdapter(productAdapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (productAdapter != null) {
            productAdapter.release();
        }
    }
}