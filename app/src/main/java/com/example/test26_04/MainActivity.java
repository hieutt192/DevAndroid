package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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
                startActivity(new Intent(getApplicationContext(),ProductActivity.class));
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),OrderActivity.class));
            }
        });

        btnStatictic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),StatisticActivity.class));
            }
        });



    }
}