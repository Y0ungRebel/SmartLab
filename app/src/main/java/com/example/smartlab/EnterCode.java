package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EnterCode extends AppCompatActivity {

    EditText first_num, second_num, third_num, fourth_num;
    int time, code, num1, num2, num3, num4;
    String num_one, num_two, num_three, num_four;
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
        code = 12;
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
    }
    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    public void onClick(View view){
        num_one = first_num.getText().toString();
        num1 = Integer.parseInt(num_one);
        num_two = second_num.getText().toString();
        num2 = Integer.parseInt(num_two);
        num_three = third_num.getText().toString();
        num3 = Integer.parseInt(num_three);
        num_four = fourth_num.getText().toString();
        num4 = Integer.parseInt(num_four);
        if ((num1 + num2 + num3 + num4) == code){
            Intent intent = new Intent(this, EnterAndRegistration.class); //ИЗМЕНИТЬ ПЕРЕХОДЯЩИЙ ИНТЕНТ НА ТОТ, КОТОРЫЙ БУДЕТ СОЗДАН ЧУТЬ ПОЗЖЕ (59 СТРОКА)
            startActivity(intent);
        }
        else {
            Toast errorToast = Toast.makeText(this, "Введен неправильный код!", Toast.LENGTH_SHORT);
            errorToast.show();
        }
    }
}

