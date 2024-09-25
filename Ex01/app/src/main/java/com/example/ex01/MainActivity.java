package com.example.ex01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ex01.R;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến giao diện
    EditText edtA, edtB, edtKQ;
    Button btncong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btncong = findViewById(R.id.btntong);

        // Xử lý sự kiện khi nhấn nút "Tổng"
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy dữ liệu từ EditText và tính tổng
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());

                // Tính tổng của hai số
                int c = a + b;

                // Hiển thị kết quả
                edtKQ.setText(String.valueOf(c));
            }
        });
    }
}
