package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Process extends AppCompatActivity {

    private Handler handler = new Handler();
    private ProgressBar progressBar1;
    private TextView textViewInfo1;

    private ImageView experiment, rules;
    private TextView finalMsg, info1st, info2nd, info3rd, info4th;
    private Button btn1st, btn2nd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);

        this.experiment = this.findViewById(R.id.experiment);
        this.rules = this.findViewById(R.id.rules);
        this.finalMsg = this.findViewById(R.id.final_msg);
        this.info1st = this.findViewById(R.id.infoTextPay_first);
        this.info2nd = this.findViewById(R.id.infoTextPay_second);
        this.info3rd = this.findViewById(R.id.infoTextPay_third);
        this.info4th = this.findViewById(R.id.infoTextPay_fourth);
        this.btn1st = this.findViewById(R.id.button_end);
        this.btn2nd = this.findViewById(R.id.btn_end);

        this.progressBar1 = this.findViewById(R.id.progressBar1);
        this.textViewInfo1 = this.findViewById(R.id.textView_info1);


            final int MAX = 200;
            this.progressBar1.setMax(MAX);
            Thread thread = new Thread(new Runnable()  {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        public void run() {

                        }
                    });
                    for( int i =0; i < MAX; i++) {
                        final int progress = i + 1;
                        // Do something (Download, Upload, Update database,..)
                        SystemClock.sleep(20); // Sleep 20 milliseconds.

                        // Update interface.
                        handler.post(new Runnable() {
                            public void run() {
                                progressBar1.setProgress(progress);
                                if(progress == 1){
                                    textViewInfo1.setText("Связываемся с банком...");
                                }
                                else if(progress == 101)  {
                                    textViewInfo1.setText("Производим оплату...");
                                }
                                else if(progress == MAX)  {
                                    progressBar1.setVisibility(View.GONE);
                                    textViewInfo1.setVisibility(View.GONE);

                                    experiment.setVisibility(View.VISIBLE);
                                    rules.setVisibility(View.VISIBLE);
                                    finalMsg.setVisibility(View.VISIBLE);
                                    info1st.setVisibility(View.VISIBLE);
                                    info2nd.setVisibility(View.VISIBLE);
                                    info3rd.setVisibility(View.VISIBLE);
                                    info4th.setVisibility(View.VISIBLE);
                                    btn1st.setVisibility(View.VISIBLE);
                                    btn2nd.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                    }
                }
            });
            thread.start();
        }
    }
