package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class nhap_hang extends AppCompatActivity {
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_hang);
        btnNext=(Button) findViewById(R.id.btnTieptuc);
//
//        ArrayList<Item> itemList = new ArrayList<>();
//        itemList.add(new Item(1,
//                "quan dai",
//                "https://cloudinary.com/console/c-6f7568c74b4802fb159ababdb87686/media_library/folders/home",
//                12,
//                20000
//        ));
//
//        Adapter adapter = new Adapter(this, itemList);
//        ListView itemListView = findViewById(R.id.listview);
//        itemListView.setAdapter(adapter);



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(nhap_hang.this,tao_don_nhap.class);
                startActivity(intent);
            }
        });


    }
}