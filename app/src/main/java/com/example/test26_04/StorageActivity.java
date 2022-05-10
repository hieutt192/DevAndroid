package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.test26_04.api_controller.productAPI;
import com.example.test26_04.models.AllProductResponse;
import com.example.test26_04.models.Item;
import com.example.test26_04.models.Product;
import com.example.test26_04.utils.CustomeAdapter;
import com.example.test26_04.utils.ProductAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StorageActivity extends AppCompatActivity {
    Button btnNhap;
    Button btnXuat;
    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlkh_index);
        btnNhap = (Button)findViewById(R.id.btnNhap);
        btnXuat=(Button)findViewById(R.id.btnXuat);

        RecyclerView productListView = (RecyclerView) findViewById(R.id.recycle_item_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        productListView.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        productListView.addItemDecoration(itemDecoration);

        Intent intent = getIntent();
        ArrayList<Product> productList = (ArrayList<Product>) intent.getSerializableExtra("Product list");

        ProductAdapter productAdapter = new ProductAdapter(this, productList, nhap_hang.class);
        productListView.setAdapter(productAdapter);


        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(StorageActivity.this, nhap_hang.class);
                startActivity(intent1);
            }
        });
        btnXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(StorageActivity.this,xuat_hang.class);
                startActivity(intent);
            }
        });
    }


}