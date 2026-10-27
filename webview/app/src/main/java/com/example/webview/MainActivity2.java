package com.example.webview;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    WebView w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        w = findViewById(R.id.w1);
        w.setWebViewClient(new WebViewClient()); //important

        Intent i = getIntent();
        String s = i.getStringExtra("load");

        if (s.equals("defaultPage")){
            w.loadUrl("https://www.google.com");
        }else if (!s.isEmpty()){
            w.loadUrl(s);
        }
    }
}