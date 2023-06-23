package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Order extends AppCompatActivity {


    EditText editAddress, editDateAndTime;
    Button goPay, addPatient;
    ImageButton btn_back;

    EditText editStreet, editLongitude, editWidth, editHeight, editFlat, editDoor, editFloor, editHouse, editPlace;
    Button saveAddress;
    Switch savePlace;

    Spinner takeDate;
    Button time1st, time2nd, time3rd, time4th, time5th, time6th, time7th, saveDate;

    Button first_patient, second_patient, savePatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        editAddress = findViewById(R.id.editAddress);
        editAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Order.this, R.style.BottomSheetDialogTheme);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_address);
                editStreet = bottomSheetDialog.findViewById(R.id.editStreet);
                editLongitude = bottomSheetDialog.findViewById(R.id.editLongitude);
                editWidth = bottomSheetDialog.findViewById(R.id.editWidth);
                editHeight = bottomSheetDialog.findViewById(R.id.editHeight);
                editFlat = bottomSheetDialog.findViewById(R.id.editFlat);
                editDoor = bottomSheetDialog.findViewById(R.id.editDoor);
                editFloor = bottomSheetDialog.findViewById(R.id.editFloor);
                editHouse = bottomSheetDialog.findViewById(R.id.editHouse);
                editPlace = bottomSheetDialog.findViewById(R.id.editPlace);
                savePlace = bottomSheetDialog.findViewById(R.id.savePlace);
                savePlace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editPlace.setVisibility(View.VISIBLE);
                    }
                });
                saveAddress = bottomSheetDialog.findViewById(R.id.btn_save_address);

                saveAddress.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if ((editStreet.getText().toString().isEmpty()) || (editLongitude.getText().toString().isEmpty()) ||
                                (editWidth.getText().toString().isEmpty()) || (editHeight.getText().toString().isEmpty()) ||
                                (editFlat.getText().toString().isEmpty()) || (editDoor.getText().toString().isEmpty()) ||
                                (editFloor.getText().toString().isEmpty()) || (editHouse.getText().toString().isEmpty())){
                            Toast errorToast = Toast.makeText(Order.this, "Заполнены не все поля!", Toast.LENGTH_SHORT);
                            errorToast.show();
                        }
                        else {
                            bottomSheetDialog.dismiss();
                            editAddress.setText(editStreet.getText() + ", кв. " + editFlat.getText());
                        }

                    }
                });

                bottomSheetDialog.show();
            }
        });


        editDateAndTime = findViewById(R.id.editDateAndTime);
        editDateAndTime.setOnClickListener(new View.OnClickListener() {
            int checker = 1;
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Order.this, R.style.BottomSheetDialogTheme);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_date);
                takeDate = bottomSheetDialog.findViewById(R.id.date);
                time1st = bottomSheetDialog.findViewById(R.id.first_time);
                time1st.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checker = 0;
                        time1st.setBackgroundResource(R.drawable.btn_category_pressed);
                        time1st.setTextColor(ContextCompat.getColor(Order.this, R.color.clear_white));
                    }
                });
                time2nd = bottomSheetDialog.findViewById(R.id.second_time);
                time2nd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checker = 0;
                        time2nd.setBackgroundResource(R.drawable.btn_category_pressed);
                        time2nd.setTextColor(ContextCompat.getColor(Order.this, R.color.clear_white));
                    }
                });
                time3rd = bottomSheetDialog.findViewById(R.id.third_time);
                time3rd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checker = 0;
                        time3rd.setBackgroundResource(R.drawable.btn_category_pressed);
                        time3rd.setTextColor(ContextCompat.getColor(Order.this, R.color.clear_white));
                    }
                });
                time4th = bottomSheetDialog.findViewById(R.id.fourth_time);
                time4th.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checker = 0;
                        time4th.setBackgroundResource(R.drawable.btn_category_pressed);
                        time4th.setTextColor(ContextCompat.getColor(Order.this, R.color.clear_white));
                    }
                });
                time5th = bottomSheetDialog.findViewById(R.id.fifth_time);
                time5th.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checker = 0;
                        time5th.setBackgroundResource(R.drawable.btn_category_pressed);
                        time5th.setTextColor(ContextCompat.getColor(Order.this, R.color.clear_white));
                    }
                });
                time6th = bottomSheetDialog.findViewById(R.id.sixth_time);
                time6th.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checker = 0;
                        time6th.setBackgroundResource(R.drawable.btn_category_pressed);
                        time6th.setTextColor(ContextCompat.getColor(Order.this, R.color.clear_white));
                    }
                });
                time7th = bottomSheetDialog.findViewById(R.id.seventh_time);
                time7th.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checker = 0;
                        time7th.setBackgroundResource(R.drawable.btn_category_pressed);
                        time7th.setTextColor(ContextCompat.getColor(Order.this, R.color.clear_white));
                    }
                });
                saveDate = bottomSheetDialog.findViewById(R.id.btn_save_date);
                saveDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (checker == 1){
                            Toast errorToast = Toast.makeText(Order.this, "Выберите время!", Toast.LENGTH_SHORT);
                            errorToast.show();
                        }
                        else {
                            bottomSheetDialog.dismiss();
                            editDateAndTime.setText(takeDate.getSelectedItem().toString() + ", 16:00");
                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });

        goPay = findViewById(R.id.btn_pay);
        goPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this, Process.class);
                startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            }
        });


//        addPatient.findViewById(R.id.button_add_item);
//        addPatient.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Order.this, R.style.BottomSheetDialogTheme);
//                bottomSheetDialog.setContentView(R.layout.bottom_sheet_patient);
//                first_patient = bottomSheetDialog.findViewById(R.id.btn_patient_first);
//                first_patient.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        first_patient.setBackgroundResource(R.drawable.btn_category_pressed);
//                        first_patient.setTextColor(ContextCompat.getColor(Order.this, R.color.clear_white));
//                    }
//                });
//                second_patient = bottomSheetDialog.findViewById(R.id.btn_patient_second);
//                second_patient.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        second_patient.setBackgroundResource(R.drawable.btn_category_pressed);
//                        second_patient.setTextColor(ContextCompat.getColor(Order.this, R.color.clear_white));
//                    }
//                });
//                savePatient = bottomSheetDialog.findViewById(R.id.btn_save_patient);
//                savePatient.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        bottomSheetDialog.dismiss();
//                    }
//                });
//
//                bottomSheetDialog.show();
//
//            }
//
//        });

    }
}