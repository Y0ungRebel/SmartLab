package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnterAndRegistration extends AppCompatActivity {

    Button next, yandex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_and_registration);
        next = findViewById(R.id.btn_next);
        yandex = findViewById(R.id.btnLogYandex);
    }
    public void onClick(View view){
        Intent intent = new Intent(this, EnterCode.class);
        startActivity(intent);
    }
}