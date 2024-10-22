package com.example.ex13_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Phone> phoneList;
    MyArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        phoneList = new ArrayList<>();
        // Thêm dữ liệu vào danh sách
        phoneList.add(new Phone("Điện thoại Iphone 12", R.drawable.iphone12));
        phoneList.add(new Phone("Điện thoại SamSung S20", R.drawable.samsung_s20));
        // Thêm các điện thoại khác...

        adapter = new MyArrayAdapter(this, R.layout.layout_listview, phoneList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("phoneName", phoneList.get(position).getNamePhone());
                startActivity(intent);
            }
        });
    }
}
