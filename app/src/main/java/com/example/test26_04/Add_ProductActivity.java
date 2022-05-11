package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.test26_04.R;

public class Add_ProductActivity extends AppCompatActivity {

    private EditText txtInputName;
    private EditText txtInputPrice;
    private EditText txtInputVendor;
    private EditText txtInputDescription;
    private Button btnClear;
    private Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        //
        txtInputName = findViewById(R.id.txt_input_Name_Product);
        txtInputName = findViewById(R.id.txt_input_Price_Product);
        txtInputName = findViewById(R.id.txt_input_Vendor_Product);
        txtInputName = findViewById(R.id.txt_input_Description_Product);

        //
        btnClear = findViewById(R.id.btn_clear);
        btnAdd = findViewById(R.id.btn_add);

        // btn clear event

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        // btn add event

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}