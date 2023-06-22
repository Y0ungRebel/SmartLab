package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Order extends AppCompatActivity {

    TextView clickAddress;
    EditText editAddress, editDateAndTime;
    Button makeOrder;

    EditText editStreet, editLongitude, editWidth, editHeight, editFlat, editDoor, editFloor, editHouse, editPlace;
    Button savePlace, saveAddress;

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
                        if (!(editStreet.getText().toString().isEmpty()) && !(editLongitude.getText().toString().isEmpty()) &&
                                !(editWidth.getText().toString().isEmpty()) && !(editHeight.getText().toString().isEmpty()) &&
                                !(editFlat.getText().toString().isEmpty()) && !(editDoor.getText().toString().isEmpty()) &&
                                !(editFloor.getText().toString().isEmpty()) && !(editHouse.getText().toString().isEmpty())){
                            saveAddress.setBackgroundResource(R.drawable.btn_next_reg);
                            saveAddress.setText(editStreet.getText() + ", кв. " + editFlat.getText());
                            bottomSheetDialog.dismiss();
                        }
                    }
                });
                bottomSheetDialog.show();
            }
        });

        editDateAndTime = findViewById(R.id.editDateAndTime);
        makeOrder = findViewById(R.id.btn_make_order);




    }
}