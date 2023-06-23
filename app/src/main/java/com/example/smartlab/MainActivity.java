package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.smartlab.CreateCard.APP_PREFERENCES_CARD_FINISH;
import static com.example.smartlab.Keyboard.APP_PREFERENCES_PIN;
import static com.example.smartlab.Keyboard.APP_PREFERENCES_SKIP_PIN;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGHT = 3000;
    private static final String MY_SETTINGS = "my_settings";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp = getSharedPreferences(MY_SETTINGS,
                        Context.MODE_PRIVATE);

                boolean hasVisited = sp.getBoolean("hasVisited", false);
                boolean hasPinSkip = sp.getBoolean(APP_PREFERENCES_SKIP_PIN, false);
                boolean hasFinishCard = sp.getBoolean(APP_PREFERENCES_CARD_FINISH, false);

                if (!hasVisited) {
                    SharedPreferences.Editor e = sp.edit();
                    e.putBoolean("hasVisited", true);
                    e.apply();
                    Intent i = new Intent(MainActivity.this, OnboardActivity.class);
                    MainActivity.this.startActivity(i);
                    MainActivity.this.finish();
                }
                else {

                    if(sp.contains(APP_PREFERENCES_PIN)) {
                        Intent i = new Intent(MainActivity.this, Keyboard.class);
                        MainActivity.this.startActivity(i);
                        MainActivity.this.finish();
                    }
                    else if (!sp.contains(APP_PREFERENCES_PIN) & hasPinSkip){
                        Intent i = new Intent(MainActivity.this, CreateCard.class);
                        MainActivity.this.startActivity(i);
                        MainActivity.this.finish();
                    }
                    else {
                        Intent i = new Intent(MainActivity.this, EnterAndRegistration.class);
                        MainActivity.this.startActivity(i);
                        MainActivity.this.finish();
                    }
                }
            }
        }, SPLASH_DISPLAY_LENGHT);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

}