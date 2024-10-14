package com.example.ex05_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity {

    private EditText editNamDuong;
    private TextView textNamAm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNamDuong = findViewById(R.id.editnamduonglich);
        textNamAm = findViewById(R.id.textView5);
        Button btnDoi = findViewById(R.id.button1);

        btnDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Bước 1: Lấy giá trị nhập từ EditText
                String namDuongStr = editNamDuong.getText().toString();

                if (namDuongStr.isEmpty()) {
                    textNamAm.setText("Vui lòng nhập năm dương lịch");
                    return;
                }

                // Bước 2: Ép giá trị nhập về số nguyên
                int namDuong = Integer.parseInt(namDuongStr);

                // Bước 3: Áp dụng bảng Can và Chi để tính năm âm lịch
                String can = layCan(namDuong);
                String chi = layChi(namDuong);

                // Hiển thị năm âm lịch
                textNamAm.setText(can + " " + chi);
            }
        });
    }

    // Hàm tính Can dựa theo bảng
    private String layCan(int namDuong) {
        switch (namDuong % 10) {
            case 0: return "Canh";
            case 1: return "Tân";
            case 2: return "Nhâm";
            case 3: return "Quý";
            case 4: return "Giáp";
            case 5: return "Ất";
            case 6: return "Bính";
            case 7: return "Đinh";
            case 8: return "Mậu";
            case 9: return "Kỷ";
        }
        return "";
    }

    // Hàm tính Chi dựa theo bảng
    private String layChi(int namDuong) {
        switch (namDuong % 12) {
            case 0: return "Thân";
            case 1: return "Dậu";
            case 2: return "Tuất";
            case 3: return "Hợi";
            case 4: return "Tý";
            case 5: return "Sửu";
            case 6: return "Dần";
            case 7: return "Mão";
            case 8: return "Thìn";
            case 9: return "Tỵ";
            case 10: return "Ngọ";
            case 11: return "Mùi";
        }
        return "";
    }
}

