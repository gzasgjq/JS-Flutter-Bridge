package com.gjq.jfb.demo.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.gjq.jfb.demo.R;

import wendu.dsbridge.DWebView;
import wendu.dsbridge.PluginManager;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        DWebView webView = findViewById(R.id.dwebview);
        Uri uri = getIntent().getData();
        String url = uri.getQueryParameter("url");
        webView.loadUrl("file:///android_asset/" + url);
    }
}