package com.example.ex22;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnparse;
    ListView lv1;
    ArrayAdapter<String> myadapter;
    ArrayList<String> mylist;
    String URL = "https://api.androidhive.info/pizza/?format=xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnparse = findViewById(R.id.btnparse);
        lv1 = findViewById(R.id.lv1);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mylist);
        lv1.setAdapter(myadapter);

        btnparse.setOnClickListener(v -> {
            LoadExampleTask task = new LoadExampleTask();
            task.execute();
        });
    }

    class LoadExampleTask extends AsyncTask<Void, Void, ArrayList<String>> {
        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> list = new ArrayList<>();
            try {
                XMLParser myparser = new XMLParser();
                String xml = myparser.getXmlFromUrl(URL); // getting XML from URL

                XmlPullParserFactory fc = XmlPullParserFactory.newInstance();
                XmlPullParser parser = fc.newPullParser();
                parser.setInput(new StringReader(xml));

                int eventType = parser.getEventType();
                String datashow = "";
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            if (parser.getName().equals("id")) {
                                datashow += parser.nextText() + "-";
                            } else if (parser.getName().equals("name")) {
                                datashow += parser.nextText();
                            }
                            break;
                        case XmlPullParser.END_TAG:
                            if (parser.getName().equals("item")) {
                                list.add(datashow);
                                datashow = "";
                            }
                            break;
                    }
                    eventType = parser.next();
                }
            } catch (XmlPullParserException | IOException e) {
                e.printStackTrace();
            }
            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            super.onPostExecute(result);
            myadapter.clear();
            myadapter.addAll(result);
            myadapter.notifyDataSetChanged();
        }
    }
}
