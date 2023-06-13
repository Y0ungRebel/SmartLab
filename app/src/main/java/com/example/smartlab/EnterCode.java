package com.example.smartlab;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;

public class EnterCode extends AppCompatActivity {

    EditText first_num, second_num, third_num, fourth_num;

    ImageButton back;

    int time;

    Integer[] correct_code = {1,3,6,2};

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

        back = findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                onBackPressed();
            }
        });

        Integer password[] = new Integer[4];

        StringBuilder sb = new StringBuilder();

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
                if(sb.length()==1)
                {
                    sb.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(sb.length()==0&first_num.length()==1)
                {
                    sb.append(s);
                    password[0]=Integer.valueOf(sb.toString());
                    if(password[0]!=null & password[1]!=null & password[2]!=null & password[3]!=null){
                        correctEmailCode(password,correct_code);
                    }
                    second_num.requestFocus();
                    second_num.setCursorVisible(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {
                    password[0]=null;
                    first_num.requestFocus();
                }
            }
        });
        //2ый ЭТ с перебросом на 3ий
        second_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(sb.length()==1)
                {
                    sb.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(sb.length()==0&second_num.length()==1)
                {
                    sb.append(s);
                    password[1]=Integer.valueOf(sb.toString());
                    if(password[0]!=null & password[1]!=null & password[2]!=null & password[3]!=null){
                        correctEmailCode(password,correct_code);
                    }
                    third_num.requestFocus();
                    third_num.setCursorVisible(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {
                    password[1]=null;
                    first_num.requestFocus();
                }
            }
        });
        //3ий ЭТ с перебросом на 4ый
        third_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(sb.length()==1)
                {
                    sb.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(sb.length()==0&third_num.length()==1)
                {
                    sb.append(s);
                    password[2]=Integer.valueOf(sb.toString());
                    if(password[0]!=null & password[1]!=null & password[2]!=null & password[3]!=null){
                        correctEmailCode(password,correct_code);
                    }
                    fourth_num.requestFocus();
                    fourth_num.setCursorVisible(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {
                    password[2]=null;
                    second_num.requestFocus();
                }
            }
        });
        //4ий ЭТ с проверкой
        fourth_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(sb.length()==1)
                {
                    sb.deleteCharAt(0);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(sb.length()==0&fourth_num.length()==1)
                {
                    sb.append(s);
                    password[3]=Integer.valueOf(sb.toString());
                    if(password[0]!=null & password[1]!=null & password[2]!=null & password[3]!=null){
                        correctEmailCode(password,correct_code);
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {
                    password[3]=null;
                    second_num.requestFocus();
                }
            }
        });
    }
    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    private void correctEmailCode(Integer[] password , Integer[] correct_code) {

        for(int i = 0; i<correct_code.length; i++)
        {
            if(password[i]!=correct_code[i]){
                Toast errorToast = Toast.makeText(this, "Введен неправильный код!", Toast.LENGTH_SHORT);
                errorToast.show();
            }
            else if(password[i]==correct_code[i]){
                if(i==correct_code.length-1){
                    Intent intent = new Intent(EnterCode.this, Keyboard.class);
                    startActivity(intent);
                    finishAffinity();
                }
            }
        }
    }
}

