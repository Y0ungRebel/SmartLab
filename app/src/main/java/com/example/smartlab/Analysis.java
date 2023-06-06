package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Analysis extends AppCompatActivity {

    TextView title, info, skip;
    ImageButton btn_first, btn_second, btn_third;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        title = findViewById(R.id.title);
        info = findViewById(R.id.info);
        skip = findViewById(R.id.skip);
        btn_first = findViewById(R.id.btn_first);
        btn_second = findViewById(R.id.btn_second);
        btn_third = findViewById(R.id.btn_third);
        image = findViewById(R.id.image);
    }
    public void onClick1(View view){
        title.setText("Анализы");
        info.setText("Экспресс сбор и получение проб");
        skip.setText("Пропустить");
        btn_first.setImageResource(R.drawable.ellipse_full);
        btn_second.setImageResource(R.drawable.ellipse_empty);
        btn_third.setImageResource(R.drawable.ellipse_empty);
        image.setImageResource(R.drawable.tube);
    }
    public void onClick2(View view){
        title.setText("Уведомления");
        info.setText("Вы быстро узнаете о результатах");
        skip.setText("Пропустить");
        btn_first.setImageResource(R.drawable.ellipse_empty);
        btn_second.setImageResource(R.drawable.ellipse_full);
        btn_third.setImageResource(R.drawable.ellipse_empty);
        image.setImageResource(R.drawable.information);
    }
    public void onClick3(View view){
        title.setText("Мониторинг");
        info.setText("Наши врачи всегда наблюдают за вашими показателями здоровья");
        skip.setText("Завершить");
        btn_first.setImageResource(R.drawable.ellipse_empty);
        btn_second.setImageResource(R.drawable.ellipse_empty);
        btn_third.setImageResource(R.drawable.ellipse_full);
        image.setImageResource(R.drawable.scientist);
    }
    public void onSkip(View view){
        Intent intent = new Intent(this, EnterAndRegistration.class);
        startActivity(intent);
    }
}