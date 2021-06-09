package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button addCameraButton;
    Button displayCameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addCameraButton = findViewById(R.id.addCameraButton);
        addCameraButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCamera.class);
                startActivity(intent);
            }
        });

        displayCameraButton = findViewById(R.id.displayCameraButton);
        displayCameraButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CameraList.class);
                startActivity(intent);
            }
        });
    }


}