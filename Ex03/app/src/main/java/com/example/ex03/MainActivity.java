package com.example.ex03;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText edt1, edt2, edt3;
    Button btncong, btntru, btnnhan, btnchia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edta);
        edt2 = findViewById(R.id.edtb);
        edt3 = findViewById(R.id.edtc);
        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        btnchia = findViewById(R.id.btnchia);
        btnnhan = findViewById(R.id.btnnhan);

        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edt1.getText().toString());
                int b = Integer.parseInt("0" + edt2.getText().toString());
                edt3.setText(" " + (a + b));
            }
        });

        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edt1.getText().toString());
                int b = Integer.parseInt("0" + edt2.getText().toString());
                edt3.setText(" " + (a - b));
            }
        });

        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edt1.getText().toString());
                int b = Integer.parseInt("0" + edt2.getText().toString());
                edt3.setText(" " + (a * b));
            }
        });

        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edt1.getText().toString());
                int b = Integer.parseInt("0" + edt2.getText().toString());
                if (b == 0) {
                    edt3.setText("B phải khác 0");
                } else {
                    edt3.setText(" " + (a / b));
                }
            }
        });
    }
}
