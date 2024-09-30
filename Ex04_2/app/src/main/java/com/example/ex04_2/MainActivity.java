package com.example.ex04_2;


import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button btnChandoan;
    EditText editTen, editChieucao, editCannang, editBMI, editChandoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần từ giao diện
        btnChandoan = findViewById(R.id.btnBMI);
        editTen = findViewById(R.id.edtten);
        editChieucao = findViewById(R.id.edtchieucao);
        editCannang = findViewById(R.id.edtcannang);
        editBMI = findViewById(R.id.edtBMI);
        editChandoan = findViewById(R.id.edtChuanDoan);

        // Xử lý sự kiện khi nhấn nút "Tính BMI"
        btnChandoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Lấy chiều cao và cân nặng từ EditText và chuyển đổi thành số
                    double H = Double.parseDouble(editChieucao.getText().toString());
                    double W = Double.parseDouble(editCannang.getText().toString());

                    // Tính chỉ số BMI
                    double BMI = W / Math.pow(H, 2);

                    // Chuẩn đoán dựa trên chỉ số BMI
                    String chandoan = "";
                    if (BMI < 18) {
                        chandoan = "Bạn gầy";
                    } else if (BMI <= 24.9) {
                        chandoan = "Bạn bình thường";
                    } else if (BMI <= 29.9) {
                        chandoan = "Bạn béo phì độ 1";
                    } else if (BMI <= 34.9) {
                        chandoan = "Bạn béo phì độ 2";
                    } else {
                        chandoan = "Bạn béo phì độ 3";
                    }

                    // Định dạng kết quả BMI với 1 chữ số sau dấu phẩy
                    DecimalFormat dcf = new DecimalFormat("#.0");
                    editBMI.setText(dcf.format(BMI)); // Hiển thị chỉ số BMI
                    editChandoan.setText(chandoan); // Hiển thị chẩn đoán

                } catch (Exception e) {
                    // Thông báo lỗi nếu có lỗi trong quá trình nhập liệu
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đúng chiều cao và cân nặng!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
