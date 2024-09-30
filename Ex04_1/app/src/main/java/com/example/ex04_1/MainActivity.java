package com.example.ex04_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;

public class MainActivity extends Activity {
    EditText edtdoC, edtdoF;
    Button btncf, btnfc, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtdoC = findViewById(R.id.edtdoC);
        edtdoF = findViewById(R.id.edtdoF);
        btncf = findViewById(R.id.btncf);
        btnfc = findViewById(R.id.btnfc);
        btnClear = findViewById(R.id.btnClear);

        btncf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doC = edtdoC.getText().toString();

                if (!doC.isEmpty()) {
                    double C = Double.parseDouble(doC);
                    double F = (C * 9 / 5) + 32;
                    edtdoF.setText(dcf.format(F));
                } else {
                    edtdoF.setText("");
                }
            }
        });

        btnfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doF = edtdoF.getText().toString();

                if (!doF.isEmpty()) {
                    double F = Double.parseDouble(doF);
                    double C = (F - 32) * 5 / 9;
                    edtdoC.setText(dcf.format(C));
                } else {
                    edtdoC.setText("");
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xóa nội dung cả hai ô nhập
                edtdoC.setText("");
                edtdoF.setText("");
            }
        });
    }
}
