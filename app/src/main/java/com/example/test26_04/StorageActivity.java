package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test26_04.models.Product;
import com.example.test26_04.utils.ProductAdapter;
import com.example.test26_04.utils.StorageAdapter;

import java.util.ArrayList;

public class StorageActivity extends AppCompatActivity {
    Button btnNhap;
    Button btnXuat;
    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlkh_index);

        RecyclerView productListView = (RecyclerView) findViewById(R.id.recycle_view_storage);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        productListView.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        productListView.addItemDecoration(itemDecoration);

        Intent intent = getIntent();
        ArrayList<Product> productList = (ArrayList<Product>) intent.getSerializableExtra("Product list");
        System.out.println(productList.size());

        StorageAdapter adapter = new StorageAdapter(this, productList);
        productListView.setAdapter(adapter);

    }


}