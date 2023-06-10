package com.example.smartlab;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EnterCode extends AppCompatActivity {

    EditText first_num, second_num, third_num, fourth_num;
    int time, CorVal, ResVal;
    String FCode="";
    TextView timer, timeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_code);

        first_num = findViewById(R.id.firstNum);
        second_num = findViewById(R.id.secondNum);
        third_num = findViewById(R.id.thirdNum);
        fourth_num = findViewById(R.id.fourthNum);
        timeInfo = findViewById(R.id.infoTimer);
        CorVal = 1362;
        time = 59;
        timer = findViewById(R.id.timer);
        new CountDownTimer(59000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(""+checkDigit(time));
                time--;
            }
            public void onFinish() {
                timer.setText("");
                timeInfo.setText("Отправить код заново");
            }
        }.start();
        //1ый ЭТ с перебросом на 2ой
        first_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(first_num.getText().toString().length()==1)
                {
                    FCode += first_num.getText().toString();
                    second_num.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //2ый ЭТ с перебросом на 3ий
        second_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(second_num.getText().toString().length()==1)
                {
                    FCode += second_num.getText().toString();
                    third_num.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //3ий ЭТ с перебросом на 4ый
        third_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(third_num.getText().toString().length()==1)
                {
                    FCode += third_num.getText().toString();
                    fourth_num.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //4ий ЭТ с проверкой
        fourth_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(fourth_num.getText().toString().length()==1)
                {
                    FCode += fourth_num.getText().toString();
                    ResVal = Integer.parseInt(FCode);
                }
                if (CorVal != ResVal){
                    FCode = "";
                    Toast errorToast = Toast.makeText(EnterCode.this, "Введен неправильный код!", Toast.LENGTH_SHORT);
                    errorToast.show();
                }
                else if (CorVal == ResVal){
                    Intent intent = new Intent(EnterCode.this, Keyboard.class);
                    startActivity(intent);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    public void onClick(View view){
        if (CorVal == ResVal){
            Intent intent = new Intent(this, Keyboard.class);
            startActivity(intent);
        }
        else {
            Toast errorToast = Toast.makeText(this, "Введен неправильный код!", Toast.LENGTH_SHORT);
            errorToast.show();
        }
    }
}

