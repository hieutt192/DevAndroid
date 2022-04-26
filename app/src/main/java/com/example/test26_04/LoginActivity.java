package com.example.test26_04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView us = (TextView) findViewById(R.id.username); // us = username
        TextView ps = (TextView) findViewById(R.id.password); // ps = password
        TextView su = (TextView) findViewById(R.id.signUp);  // su = sign up
        MaterialButton btnLogin = (MaterialButton) findViewById(R.id.btnLogin);

        // Login process
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        // Sign-in process
        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
            }
        });
    }
}