package com.example.ex08_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnCall, btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btncallphone);
        btnSend = findViewById(R.id.btnsendsms);

        // Sự kiện cho nút Call Phone
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, CallPhoneActivity.class);
                startActivity(intent1);
            }
        });

        // Sự kiện cho nút Send SMS
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, SendSMSActivity.class);
                startActivity(intent2);
            }
        });
    }
}