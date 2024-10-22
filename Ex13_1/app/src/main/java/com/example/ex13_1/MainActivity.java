package com.example.ex13_1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView selection;
    AutoCompleteTextView singleComplete;
    MultiAutoCompleteTextView multiComplete;

    // Mảng chứa danh sách tỉnh thành
    String arr[] = {"Hà Nội", "Huế", "Sài Gòn", "Hà Giang", "Hội An", "Kiên Giang", "Lâm Đồng", "Long Khánh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selection = findViewById(R.id.selection);
        singleComplete = findViewById(R.id.editauto);
        multiComplete = findViewById(R.id.multiAutoCompleteTextView1);

        // Tạo ArrayAdapter cho AutoCompleteTextView
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        singleComplete.setAdapter(myAdapter);

        // Đặt listener cho AutoCompleteTextView
        singleComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                selection.setText(singleComplete.getText());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Tạo ArrayAdapter cho MultiAutoCompleteTextView
        multiComplete.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr));
        multiComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}