package com.example.ex19;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnParse;
    ListView lv;
    ArrayList<String> myList;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParse = findViewById(R.id.btnparse);
        lv = findViewById(R.id.lv);

        myList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        lv.setAdapter(myAdapter);

        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseXML();
            }
        });
    }

    private void parseXML() {
        try {
            InputStream myInput = getAssets().open("employee.xml");
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(myInput, null);
            int eventType = parser.getEventType();
            String dataShow = "";

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        String nodeName = parser.getName();
                        if (nodeName.equals("employee")) {
                            dataShow = parser.getAttributeValue(0) + "-" + parser.getAttributeValue(1) + "-";
                        } else if (nodeName.equals("name")) {
                            parser.next();
                            dataShow += parser.getText() + "-";
                        } else if (nodeName.equals("phone")) {
                            parser.next();
                            dataShow += parser.getText();
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("employee")) {
                            myList.add(dataShow);
                            dataShow = "";
                        }
                        break;
                }
                eventType = parser.next();
            }
            myAdapter.notifyDataSetChanged();

        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}
