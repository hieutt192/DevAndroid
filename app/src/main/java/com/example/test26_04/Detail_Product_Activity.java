package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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

        ImageView imageView = findViewById(R.id.img_Detail);
        Glide.with(this).load(product.getImage()).into(imageView);

        TextView priceView = findViewById(R.id.txt_Price_Product);
        priceView.setText(String.valueOf(product.getPrice()));

        TextView descriptionView = findViewById(R.id.txt_Description_Product);
        descriptionView.setText(product.getDescription());

    }
}