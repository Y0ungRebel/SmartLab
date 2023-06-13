package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class EnterAndRegistration extends AppCompatActivity {

    Button next, yandex;
    EditText editEmail;
    SharedPreferences preferences;
    String emailValue, emailPattern;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_and_registration);
        next = findViewById(R.id.btn_next);
        yandex = findViewById(R.id.btnLogYandex);
        editEmail = findViewById(R.id.editEmail);

        editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Patterns.EMAIL_ADDRESS.matcher(editEmail.getText().toString()).matches()){
                    next.setEnabled(true);
                }
                else next.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void onClick(View view){
        emailValue = editEmail.getText().toString();
        emailPattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+";

        preferences = getSharedPreferences("UserInfo", 0);

        if ((emailValue.matches(emailPattern))) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("email", emailValue);
            editor.apply();
            Toast.makeText(this, "Успешно!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, EnterCode.class);
            startActivity(intent);
        }
        else if (!emailValue.matches(emailPattern)) {
            Toast.makeText(this, "Это поле не может быть пустым!", Toast.LENGTH_SHORT).show();
        }
    }


}