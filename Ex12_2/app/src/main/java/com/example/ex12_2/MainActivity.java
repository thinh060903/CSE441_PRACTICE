package com.example.ex12_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends Activity {
    TextView txt1;
    EditText edtwork, edth, edtm;
    Button btnwork;
    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String> arrAdapater;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.selection);
        edtwork = findViewById(R.id.edtwork);
        edth = findViewById(R.id.edthour);
        edtm = findViewById(R.id.edtmi);
        btnwork = findViewById(R.id.btnadd);
        lv = findViewById(R.id.listView1);

        // Khởi tạo SharedPreferences
        sharedPreferences = getSharedPreferences("work_prefs", MODE_PRIVATE);
        arraywork = new ArrayList<>();

        // Khôi phục dữ liệu đã lưu
        loadWork();

        arrAdapater = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraywork);
        lv.setAdapter(arrAdapater);

        // Xử lý khi nhấn nút "Add Work"
        btnwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtwork.getText().toString().isEmpty() || edth.getText().toString().isEmpty() || edtm.getText().toString().isEmpty()) {
                    // Hiện thông báo nếu có trường trống
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info missing");
                    builder.setMessage("Please enter all information of the work");
                    builder.setPositiveButton("Continue", null);
                    builder.show();
                } else {
                    String str = edtwork.getText().toString() + " - " + edth.getText().toString() + ":" + edtm.getText().toString();
                    arraywork.add(str);
                    arrAdapater.notifyDataSetChanged();
                    saveWork();
                    edtwork.setText("");
                    edth.setText("");
                    edtm.setText("");
                }
            }
        });

        // Xử lý sự kiện khi chọn mục trong ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int i, long arg3) {
                arraywork.remove(i);
                arrAdapater.notifyDataSetChanged();
                saveWork();
            }
        });
    }

    private void saveWork() {
        // Lưu dữ liệu vào SharedPreferences
        Set<String> set = new HashSet<>(arraywork);
        sharedPreferences.edit().putStringSet("work_set", set).apply();
    }

    private void loadWork() {
        // Khôi phục dữ liệu từ SharedPreferences
        Set<String> set = sharedPreferences.getStringSet("work_set", new HashSet<>());
        arraywork.clear();
        arraywork.addAll(set);
    }
}