package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddCamera extends AppCompatActivity {

    Button addCameraButton;
    EditText editCameraName, editIpAddress, editPort, editUserName, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_camera);

        editCameraName =  findViewById(R.id.editCameraName);
        editIpAddress =  findViewById(R.id.editIpAddress);
        editPort =  findViewById(R.id.editPort);
        editUserName =  findViewById(R.id.editUserName);
        editPassword =  findViewById(R.id.editPassword);
        addCameraButton = findViewById(R.id.addCameraButton);

        addCameraButton.setEnabled(false);

        editCameraName.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                checkIfEmpty();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        editIpAddress.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                checkIfEmpty();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        editPort.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                checkIfEmpty();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        editUserName.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                checkIfEmpty();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        editPassword.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                checkIfEmpty();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });


        addCameraButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                try {

                    CameraModel camera = new CameraModel(
                            editCameraName.getText().toString(),
                            editIpAddress.getText().toString(),
                            Integer.parseInt(editPort.getText().toString()),
                            editUserName.getText().toString(),
                            editPassword.getText().toString(),
                            -1
                    );

                    DataBaseHelper dataBaseHelper = new DataBaseHelper(AddCamera.this);
                    boolean success = dataBaseHelper.addOne(camera);

                    if(success){
                        Toast.makeText(AddCamera.this,"Camera added successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddCamera.this, CameraList.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(AddCamera.this, "Error adding a camera.", Toast.LENGTH_SHORT).show();
                    }

                }
                catch (Exception e){
                    Toast.makeText(AddCamera.this, "Error adding a camera.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void checkIfEmpty() {

        if(editCameraName.getText().toString().trim().length()==0   ||
                editIpAddress.getText().toString().trim().length()==0 ||
                editPort.getText().toString().trim().length()==0 ||
                editUserName.getText().toString().trim().length()==0 ||
                editPassword.getText().toString().trim().length()==0 &&  editPort.getText().toString().trim().isEmpty()){
            addCameraButton.setEnabled(false);
        } else {
            addCameraButton.setEnabled(true);
        }
    }

}