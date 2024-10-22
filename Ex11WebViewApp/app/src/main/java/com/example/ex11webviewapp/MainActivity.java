package com.example.ex11webviewapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Uri data = intent.getData();
        try {
            WebView webView = findViewById(R.id.webview1);
            webView.loadUrl(data.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}