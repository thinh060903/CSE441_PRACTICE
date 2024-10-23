package com.example.ex21;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnparse;
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnparse = findViewById(R.id.btnparse);
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);

        btnparse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseJson();
            }
        });
    }

    private void parseJson() {
        String json = null;
        try {
            // Đọc file JSON từ thư mục assets
            InputStream inputStream = getAssets().open("computer.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

            // Phân tích JSON
            JSONObject reader = new JSONObject(json);
            mylist.add(reader.getString("MaDM"));
            mylist.add(reader.getString("TenDM"));

            JSONArray myArray = reader.getJSONArray("Sanphams");
            for (int i = 0; i < myArray.length(); i++) {
                JSONObject myObj = myArray.getJSONObject(i);
                mylist.add(myObj.getString("MaSP") + " - " + myObj.getString("TenSP"));
                mylist.add(myObj.getString("SoLuong") + " * " + myObj.getString("DonGia") + " = " + myObj.getString("ThanhTien"));
                mylist.add(myObj.getString("Hinh"));
            }
            myadapter.notifyDataSetChanged();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}