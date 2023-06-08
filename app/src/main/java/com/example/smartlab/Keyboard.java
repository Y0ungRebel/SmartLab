package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Keyboard extends AppCompatActivity implements View.OnClickListener{

    ImageButton ind_1st, ind_2nd, ind_3rd, ind_4th, rb_remove;
    Button rb0, rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9;
    ArrayList<String> numbers_list = new ArrayList<>();
    String passCode = "";
    String num1, num2, num3, num4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        ind_1st = findViewById(R.id.btn_1st);
        ind_2nd = findViewById(R.id.btn_2nd);
        ind_3rd = findViewById(R.id.btn_3rd);
        ind_4th = findViewById(R.id.btn_4th);
        rb_remove = findViewById(R.id.clear_btn);

        rb0 = findViewById(R.id.rb0);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        rb6 = findViewById(R.id.rb6);
        rb7 = findViewById(R.id.rb7);
        rb8 = findViewById(R.id.rb8);
        rb9 = findViewById(R.id.rb9);

        rb0.setOnClickListener(this);
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);
        rb5.setOnClickListener(this);
        rb6.setOnClickListener(this);
        rb7.setOnClickListener(this);
        rb8.setOnClickListener(this);
        rb9.setOnClickListener(this);
        rb_remove.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rb0:
                numbers_list.add("0");
                passNum(numbers_list);
                break;
            case R.id.rb1:
                numbers_list.add("1");
                passNum(numbers_list);
                break;
            case R.id.rb2:
                numbers_list.add("2");
                passNum(numbers_list);
                break;
            case R.id.rb3:
                numbers_list.add("3");
                passNum(numbers_list);
                break;
            case R.id.rb4:
                numbers_list.add("4");
                passNum(numbers_list);
                break;
            case R.id.rb5:
                numbers_list.add("5");
                passNum(numbers_list);
                break;
            case R.id.rb6:
                numbers_list.add("6");
                passNum(numbers_list);
                break;
            case R.id.rb7:
                numbers_list.add("7");
                passNum(numbers_list);
                break;
            case R.id.rb8:
                numbers_list.add("8");
                passNum(numbers_list);
                break;
            case R.id.rb9:
                numbers_list.add("9");
                passNum(numbers_list);
                break;
            case R.id.clear_btn:
                numbers_list.clear();
                passNum(numbers_list);
                break;
        }

    }

    private void passNum(ArrayList<String> numbers_list) {
        if (numbers_list.size() == 0){
            ind_1st.setImageResource(R.drawable.ellipse_empty);
            ind_2nd.setImageResource(R.drawable.ellipse_empty);
            ind_3rd.setImageResource(R.drawable.ellipse_empty);
            ind_4th.setImageResource(R.drawable.ellipse_empty);
        }
        else {
            switch (numbers_list.size()){
                case 1:
                    num1 = numbers_list.get(0);
                    ind_1st.setImageResource(R.drawable.ellipse_full);
                    break;
                case 2:
                    num2 = numbers_list.get(1);
                    ind_2nd.setImageResource(R.drawable.ellipse_full);
                    break;
                case 3:
                    num3 = numbers_list.get(2);
                    ind_3rd.setImageResource(R.drawable.ellipse_full);
                    break;
                case 4:
                    num4 = numbers_list.get(3);
                    ind_4th.setImageResource(R.drawable.ellipse_full);
                    passCode = num1 + num2 + num3 + num4;
                    startActivity(new Intent(this, CreateCard.class));
                    if (getPassCode().length() == 0){
                        savePassCode(passCode);
                    }
                    else {
                        matchPassCode();
                    }
                    break;
            }
        }
    }

    private void matchPassCode() {
        if (getPassCode().equals(passCode)){
            startActivity(new Intent(this, CreateCard.class));
        }
    }

    private SharedPreferences.Editor savePassCode(String passCode){
        SharedPreferences preferences = getSharedPreferences("passcode_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("passcode", passCode);
        editor.commit();
        return editor;
    }

    private String getPassCode(){
        SharedPreferences preferences = getSharedPreferences("passcode_pref", Context.MODE_PRIVATE);
        return preferences.getString("passcode","");
    }

    public void onSkip(View view){
        Intent intent = new Intent(this, CreateCard.class);
        startActivity(intent);
    }
}