package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.test26_04.models.Item;
import com.example.test26_04.utils.Adapter;

import java.util.ArrayList;

public class nhap_hang extends AppCompatActivity {
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_hang);
        btnNext=(Button) findViewById(R.id.btnTieptuc);

        ArrayList<Item> itemList = new ArrayList<>();
        Adapter adapter = new Adapter(itemList);

        ListView itemListView = findViewById(R.id.listview);
        itemListView.setAdapter(adapter);

        itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

//        ArrayAdapter <Item> adapter

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(nhap_hang.this,tao_don_nhap.class);
                startActivity(intent);
            }
        });


    }
}