package com.example.ex15;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtmalop, edttenlop, edtsiso;
    Button btninsert, btndelete, btnupdate, btnquery;
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    DatabaseHelper mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các biến
        edtmalop = findViewById(R.id.edtmalop);
        edttenlop = findViewById(R.id.edttenlop);
        edtsiso = findViewById(R.id.edtsiso);
        btninsert = findViewById(R.id.btninsert);
        btndelete = findViewById(R.id.btndelete);
        btnupdate = findViewById(R.id.btnupdate);
        btnquery = findViewById(R.id.btnquery);
        lv = findViewById(R.id.lv);

        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);

        // Khởi tạo cơ sở dữ liệu
        mydatabase = new DatabaseHelper(this);

        // Thêm sự kiện cho nút INSERT
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edtmalop.getText().toString();
                String tenlop = edttenlop.getText().toString();
                int siso = Integer.parseInt(edtsiso.getText().toString());

                ContentValues myvalue = new ContentValues();
                myvalue.put("malop", malop);
                myvalue.put("tenlop", tenlop);
                myvalue.put("siso", siso);

                if (mydatabase.getWritableDatabase().insert("tbllop", null, myvalue) == -1) {
                    Toast.makeText(MainActivity.this, "Fail to Insert Record!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Insert record Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Thêm sự kiện cho nút QUERY
        btnquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist.clear();
                Cursor c = mydatabase.getReadableDatabase().query("tbllop", null, null, null, null, null, null);
                if (c != null) {
                    while (c.moveToNext()) {
                        String data = c.getString(0) + " - " + c.getString(1) + " - " + c.getInt(2);
                        mylist.add(data);
                    }
                    c.close();
                }
                myadapter.notifyDataSetChanged();
            }
        });
    }
}
