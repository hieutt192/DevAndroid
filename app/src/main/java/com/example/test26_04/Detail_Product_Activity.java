package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.test26_04.R;
import com.example.test26_04.models.Product;

public class Detail_Product_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        Bundle bundle = getIntent().getExtras();

        if (bundle == null){
            return;
        }
        Product product = (Product) bundle.get("Object Product");

        TextView textView = findViewById(R.id.txt_Name_Product);
        textView.setText(product.getName());
    }
}