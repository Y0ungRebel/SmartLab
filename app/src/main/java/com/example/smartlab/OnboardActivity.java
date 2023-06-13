package com.example.smartlab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class OnboardActivity extends AppCompatActivity {


    ViewPager mSlideViewPager;
    LinearLayout mDotLayout;
    TextView btn_skip;

    ImageView[] dots;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
        setContentView(R.layout.onboard_activity);

        btn_skip = findViewById(R.id.buttonSkip);

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getItem(0) < 2)
                    mSlideViewPager.setCurrentItem(getItem(1),true);
                else {
                    btn_skip.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    Intent i = new Intent(OnboardActivity.this, EnterAndRegistration.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        mSlideViewPager = (ViewPager) findViewById(R.id.onboardViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.linearLayout);

        viewPagerAdapter = new ViewPagerAdapter(this);
        mSlideViewPager.setAdapter(viewPagerAdapter);

        setUpIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);
    }

    public void setUpIndicator(int position){

        dots = new ImageView[3];
        mDotLayout.removeAllViews();

        for (int i = 0 ; i < dots.length ; i++){

            dots[i] = new ImageView(this);
            dots[i].setPaddingRelative(8,0,8,0);
            dots[i].setImageResource(R.drawable.ellipse_empty);
            mDotLayout.addView(dots[i]);
        }
        dots[position].setImageResource(R.drawable.ellipse_full);

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            setUpIndicator(position);

            if (position == 2){

                btn_skip.setText("Завершить");

            }else {

                btn_skip.setText("Пропустить");

            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    private int getItem(int i){
        return mSlideViewPager.getCurrentItem() + i;
    }

}