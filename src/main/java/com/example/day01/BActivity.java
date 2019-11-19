package com.example.day01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BActivity extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        initView();
    }

    private void initView() {
        web = (WebView) findViewById(R.id.web);
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        web.loadUrl(data);
        web.setWebViewClient(new WebViewClient());
    }
}
