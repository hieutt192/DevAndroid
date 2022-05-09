package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StorageActivity extends AppCompatActivity {
    Button btnNhap;
    Button btnXuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlkh_index);
        btnNhap = (Button)findViewById(R.id.btnNhap);
        btnXuat=(Button)findViewById(R.id.btnXuat);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(StorageActivity.this,nhap_hang.class);
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