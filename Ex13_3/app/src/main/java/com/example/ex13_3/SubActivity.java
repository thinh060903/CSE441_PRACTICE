package com.example.ex13_3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    TextView txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        txtPhone = findViewById(R.id.txt_subphone);
        String phoneName = getIntent().getStringExtra("phoneName");
        txtPhone.setText(phoneName);
    }
}
