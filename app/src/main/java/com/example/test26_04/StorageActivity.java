package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.test26_04.models.Item;
import com.example.test26_04.utils.CustomeAdapter;

import java.util.ArrayList;

public class StorageActivity extends AppCompatActivity {
    Button btnNhap;
    Button btnXuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlkh_index);
        btnNhap = (Button)findViewById(R.id.btnNhap);
        btnXuat=(Button)findViewById(R.id.btnXuat);

        ArrayList<Item> productList = new ArrayList<>();
        productList.add(new Item(
                1,
                "quan dai",
                "https://cloudinary.com/console/c-6f7568c74b4802fb159ababdb87686/media_library/folders/home",
                12,
                20000
        ));
        RecyclerView productListView = (RecyclerView) findViewById(R.id.recycle_item_list);
        productListView.setLayoutManager(new LinearLayoutManager(this));
        CustomeAdapter adapter = new CustomeAdapter(this, productList);
        productListView.setAdapter(adapter);


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