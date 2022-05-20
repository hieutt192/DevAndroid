package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test26_04.api_controller.orderAPI;
import com.example.test26_04.models.Customer;
import com.example.test26_04.models.Order;
import com.example.test26_04.models.Product;
import com.example.test26_04.models.ProductIdAndQuantity;
import com.example.test26_04.utils.ConfirmBuyingProductAdapter;
import com.example.test26_04.utils.ThemMoiProductAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class confirm extends AppCompatActivity {
    private Button btnFinish;
    private ArrayList<Product> buyingProductList;
    private ArrayList<ProductIdAndQuantity> productIdAndQuantities;
    private RecyclerView rvBuyingProductList;
    private ConfirmBuyingProductAdapter adapter;
    private TextView tvTotalPrice;
    private EditText etCustomerName;
    private EditText etCustomerAddress;
    private EditText etCustomerPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        btnFinish =(Button) findViewById(R.id.btnFinish);
        tvTotalPrice = findViewById(R.id.tv_total_price);
        etCustomerName = findViewById(R.id.et_customer_name);
        etCustomerAddress = findViewById(R.id.et_customer_address);
        etCustomerPhoneNumber =  findViewById(R.id.et_customer_phone);

        Intent intent = getIntent();
        buyingProductList = (ArrayList<Product>) intent.getSerializableExtra("buyingProductList");
        productIdAndQuantities = (ArrayList<ProductIdAndQuantity>) intent.getSerializableExtra("productIdAndQuantities");

        rvBuyingProductList = findViewById(R.id.rv_buying_product_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvBuyingProductList.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvBuyingProductList.addItemDecoration(itemDecoration);

        adapter = new ConfirmBuyingProductAdapter(this,  productIdAndQuantities, buyingProductList);
        rvBuyingProductList.setAdapter(adapter);

        tvTotalPrice.setText(String.valueOf(adapter.getTotalPrice()));

        btnFinish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Customer customer = new Customer(
                        etCustomerName.getText().toString().trim(),
                        etCustomerAddress.getText().toString().trim(),
                        etCustomerPhoneNumber.getText().toString().trim()
                );
                Order order = new Order(
                        productIdAndQuantities,
                        customer,
                        "pending",
                        adapter.getTotalPrice()
                );

                orderAPI.apiService
                        .addOrder(order)
                        .enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                Toast.makeText(confirm.this, response.body(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(confirm.this, "Can not call API", Toast.LENGTH_SHORT).show();
                            }
                        });

                Intent intent= new Intent(confirm.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}