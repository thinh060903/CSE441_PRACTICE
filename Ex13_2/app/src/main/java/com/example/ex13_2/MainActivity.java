package com.example.ex13_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {
    String arr[] = {
            "Ipad", "Iphone", "New Ipad",
            "SamSung", "Nokia", "Sony Ericson",
            "LG", "Q-Mobile", "HTC",
            "Blackberry", "G Phone", "FPT - Phone", "HK Phone"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView selection = findViewById(R.id.selection);
        final GridView gv = findViewById(R.id.gridView1);

        // Gán DataSource vào ArrayAdapter
        ArrayAdapter<String> da = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );

        // Gán DataSource vào GridView
        gv.setAdapter(da);

        // Thiết lập sự kiện cho GridView
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // Hiển thị phần tử được chọn trong GridView lên TextView
                selection.setText(arr[arg2]);
            }
        });
    }
}