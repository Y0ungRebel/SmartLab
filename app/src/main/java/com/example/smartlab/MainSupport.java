package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainSupport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_support);
    }
    public void onBack(View view){
        onBackPressed();
    }

    public void onAnalysis(View view){
        Intent intent = new Intent(this, MainAnalysis.class);
        startActivity(intent);
    }

    public void onResults(View view){
        Intent intent = new Intent(this, MainResult.class);
        startActivity(intent);
    }

    public void onSupport(View view){
        Intent intent = new Intent(this, MainSupport.class);
        startActivity(intent);
    }

    public void onProfile(View view){
        Intent intent = new Intent(this, MainProfile.class);
        startActivity(intent);
    }
}