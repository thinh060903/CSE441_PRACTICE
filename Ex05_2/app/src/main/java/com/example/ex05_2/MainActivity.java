package com.example.ex05_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends Activity {

    Button btnTieptuc, btnGiai, btnThoat;
    EditText edita, editb, editc;
    TextView txtkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các view từ giao diện
        btnTieptuc = findViewById(R.id.btntieptuc);
        btnGiai = findViewById(R.id.btngiaipt);
        btnThoat = findViewById(R.id.btnthoat);
        edita = findViewById(R.id.edta);
        editb = findViewById(R.id.edtb);
        editc = findViewById(R.id.edtc);
        txtkq = findViewById(R.id.txtkq);

        // Sự kiện nút Giải PT
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ EditText
                String sa = edita.getText().toString();
                String sb = editb.getText().toString();
                String sc = editc.getText().toString();

                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);

                // Tạo format để định dạng số thập phân
                DecimalFormat dcf = new DecimalFormat("0.00");
                String kq = "";

                // Xử lý phương trình
                if (a == 0) {
                    if (b == 0) {
                        if (c == 0) {
                            kq = "PT vô số nghiệm";
                        } else {
                            kq = "PT vô nghiệm";
                        }
                    } else {
                        kq = "PT có 1 nghiệm x = " + dcf.format(-c / (double) b);
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        kq = "PT vô nghiệm";
                    } else if (delta == 0) {
                        kq = "PT có nghiệm kép x1 = x2 = " + dcf.format(-b / (2 * a));
                    } else {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        kq = "PT có 2 nghiệm: x1 = " + dcf.format(x1) + "; x2 = " + dcf.format(x2);
                    }
                }

                // Hiển thị kết quả
                txtkq.setText(kq);
            }
        });

        // Sự kiện nút Tiếp tục
        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xóa trắng dữ liệu và focus vào ô nhập a
                edita.setText("");
                editb.setText("");
                editc.setText("");
                edita.requestFocus();
            }
        });

        // Sự kiện nút Thoát
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đóng ứng dụng
                finish();
            }
        });
    }
}