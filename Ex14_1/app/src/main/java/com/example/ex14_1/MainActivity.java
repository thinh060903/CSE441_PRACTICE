package com.example.ex14_1;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class MainActivity extends TabActivity {
    EditText edta, edtb;
    Button btncong;
    ListView lv1;
    ArrayList<String> list;
    ArrayAdapter<String> myarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xulycong();
            }
        });
    }

    private void Xulycong() {
        int a = Integer.parseInt(edta.getText().toString());
        int b = Integer.parseInt(edtb.getText().toString());
        String c = a + " + " + b + " = " + (a + b);
        list.add(c);
        myarray.notifyDataSetChanged();
        edta.setText("");
        edtb.setText("");
    }

    private void addControl() {
        TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
        tab.setup();

        TabHost.TabSpec tab1 = tab.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("Phép cộng");
        tab.addTab(tab1);

        TabHost.TabSpec tab2 = tab.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("Lịch sử");
        tab.addTab(tab2);

        edta = (EditText) findViewById(R.id.edta);
        edtb = (EditText) findViewById(R.id.edtb);
        btncong = (Button) findViewById(R.id.btncong);
        lv1 = (ListView) findViewById(R.id.lv1);
        list = new ArrayList<>();
        myarray = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lv1.setAdapter(myarray);
    }
}
