package com.example.ex16;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb, edtkq, txtlichsu;
    Button btntong, btnclear;
    String lichsu = ""; // Lưu trữ lịch sử tính toán

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kết nối các view
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtkq = findViewById(R.id.edtkq);
        btntong = findViewById(R.id.btntong);
        btnclear = findViewById(R.id.btnclear);
        txtlichsu = findViewById(R.id.txtlichsu);

        // Lấy lịch sử từ SharedPreferences
        SharedPreferences myprefs = getSharedPreferences("mysave", MODE_PRIVATE);
        lichsu = myprefs.getString("ls", "");
        txtlichsu.setText(lichsu);

        // Thiết lập sự kiện cho nút TỔNG
        btntong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int kq = a + b;
                edtkq.setText(String.valueOf(kq));

                // Cập nhật lịch sử
                lichsu += a + " + " + b + " = " + kq + "\n";
                txtlichsu.setText(lichsu);
            }
        });

        // Thiết lập sự kiện cho nút CLEAR
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lichsu = "";
                txtlichsu.setText(lichsu);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Lưu lịch sử vào SharedPreferences
        SharedPreferences myprefs = getSharedPreferences("mysave", MODE_PRIVATE);
        SharedPreferences.Editor myedit = myprefs.edit();
        myedit.putString("ls", lichsu);
        myedit.apply();
    }
}
