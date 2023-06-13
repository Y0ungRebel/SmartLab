package com.example.smartlab;

import static com.example.smartlab.CreateCard.APP_PREFERENCES_CARD_FINISH;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Keyboard extends AppCompatActivity implements View.OnClickListener{

    private static final String MY_SETTINGS = "my_settings";
    public static final String APP_PREFERENCES_PIN = "passcode";
    public static final String APP_PREFERENCES_SKIP_PIN = "skip_passcode";

    ImageButton ind_1st, ind_2nd, ind_3rd, ind_4th, rb_remove;

    Button rb0, rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9;

    ArrayList<String> numberList = new ArrayList<>();

    String passCode = "";

    String num1, num2, num3, num4;

    TextView head, btn_skip;

    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_keyboard);

        ind_1st = findViewById(R.id.btn_1st);
        ind_2nd = findViewById(R.id.btn_2nd);
        ind_3rd = findViewById(R.id.btn_3rd);
        ind_4th = findViewById(R.id.btn_4th);

        rb_remove = findViewById(R.id.clear_btn);
        btn_skip = findViewById(R.id.skipPas);

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

        btn_skip.setOnClickListener(this);

        head = findViewById(R.id.textView);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);

        SharedPreferences sp = getSharedPreferences(MY_SETTINGS,
                Context.MODE_PRIVATE);

        if (sp.contains(APP_PREFERENCES_PIN)) {
            head.setText("Введите пароль");
            layout.removeView(btn_skip);
        }
    }

    @Override
    public void onClick(View v){
        int id = v.getId();
        if(id == R.id.skipPas){
            SharedPreferences sp = getSharedPreferences(MY_SETTINGS,
                    Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            if(flag){
                sp.edit().remove(APP_PREFERENCES_PIN).apply();
                passNum(numberList);
                head.setText("Создайте пароль");
                btn_skip.setText("Пропустить");
                numberList.clear();
                passNum(numberList);
                flag = false;
            }
            else {
                editor.putBoolean(APP_PREFERENCES_SKIP_PIN, true);
                editor.apply();
                Intent mainIntent = new Intent(Keyboard.this, CreateCard.class);
                this.startActivity(mainIntent);
                this.finish();
            }
            btn_skip.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
        if (id == R.id.rb1){
            numberList.add("1");
            passNum(numberList);
            rb1.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
        else if (id == R.id.rb2){
            numberList.add("2");
            passNum(numberList);
            rb2.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
        else if (id == R.id.rb3){
            numberList.add("3");
            passNum(numberList);
            rb3.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
        else if (id == R.id.rb4){
            numberList.add("4");
            passNum(numberList);
            rb4.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
        else if (id == R.id.rb5){
            numberList.add("5");
            passNum(numberList);
            rb5.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
        else if (id == R.id.rb6){
            numberList.add("6");
            passNum(numberList);
            rb6.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
        else if (id == R.id.rb7){
            numberList.add("7");
            passNum(numberList);
            rb7.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
        else if (id == R.id.rb8){
            numberList.add("8");
            passNum(numberList);
            rb8.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
        else if (id == R.id.rb9){
            numberList.add("9");
            passNum(numberList);
            rb9.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
        else if (id == R.id.rb0){
            numberList.add("0");
            passNum(numberList);
            rb0.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
        else if (id == R.id.clear_btn) {
            switch (numberList.size()){
                case 1:
                    numberList.remove(0);
                    ind_1st.setImageResource(R.drawable.ellipse_empty);
                    break;
                case 2:
                    numberList.remove(1);
                    ind_2nd.setImageResource(R.drawable.ellipse_empty);
                    break;
                case 3:
                    numberList.remove(2);
                    ind_3rd.setImageResource(R.drawable.ellipse_empty);
                    break;
                case 4:
                    numberList.remove(3);
                    ind_4th.setImageResource(R.drawable.ellipse_empty);
                    break;
            }
            passNum(numberList);
            rb_remove.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
    }

    private void passNum(ArrayList<String> numberList) {
        if (numberList.size() == 0){
            ind_1st.setImageResource(R.drawable.ellipse_empty);
            ind_2nd.setImageResource(R.drawable.ellipse_empty);
            ind_3rd.setImageResource(R.drawable.ellipse_empty);
            ind_4th.setImageResource(R.drawable.ellipse_empty);
        }
        else {
            switch (numberList.size()){
                case 1:
                    num1 = numberList.get(0);
                    ind_1st.setImageResource(R.drawable.ellipse_full);
                    break;
                case 2:
                    num2 = numberList.get(1);
                    ind_2nd.setImageResource(R.drawable.ellipse_full);
                    break;
                case 3:
                    num3 = numberList.get(2);
                    ind_3rd.setImageResource(R.drawable.ellipse_full);
                    break;
                case 4:
                    num4 = numberList.get(3);
                    ind_4th.setImageResource(R.drawable.ellipse_full);
                    passCode = num1 + num2 + num3 + num4;

                    if (getPassCode().length() == 0){
                        savePassCode(passCode);
                        flag = true;
                        Intent mainIntent = new Intent(Keyboard.this, CreateCard.class);
                        this.startActivity(mainIntent);
                        this.finish();
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

            Toast errorToast = Toast.makeText(this, "Пароль введен правильно!", Toast.LENGTH_SHORT);
            errorToast.show();

            SharedPreferences sp = getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE);
            if(!sp.contains(APP_PREFERENCES_CARD_FINISH)){
                startActivity(new Intent(this, CreateCard.class));
                this.finish();
            }
            else{
                startActivity(new Intent(this, MainAnalysis.class));
                this.finish();
            }
        }
        else {
            Toast errorToast = Toast.makeText(this, "Пароль введен неверно!", Toast.LENGTH_SHORT);
            errorToast.show();
        }
    }

    private SharedPreferences.Editor savePassCode(String passCode){
        SharedPreferences preferences = getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(APP_PREFERENCES_PIN, passCode);
        editor.apply();
        return editor;
    }

    private String getPassCode(){
        SharedPreferences preferences = getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE);
        return preferences.getString(APP_PREFERENCES_PIN, "");
    }

    public void onSkip(View view){
        Intent intent = new Intent(this, CreateCard.class);
        startActivity(intent);
    }
}