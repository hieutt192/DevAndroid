package com.example.test26_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class them_moi extends AppCompatActivity {
    Button  btnTaoDon;
    @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_moi);
        btnTaoDon = (Button)findViewById(R.id.btnTaoDon);

        btnTaoDon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(them_moi.this, confirm.class);
                startActivity(intent);
            }
        });
    }

}