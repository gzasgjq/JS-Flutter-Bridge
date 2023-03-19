package com.gjq.jfb.demo.pages;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.gjq.jfb.demo.R;
import com.gjq.jfb.demo.bases.BaseActivity;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;

import java.util.HashMap;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openFlutter(View view) {
        HashMap<String, Object> arguments = new HashMap<>();
        arguments.put("data", "from Native");
        FlutterBoost.instance().open(
                new FlutterBoostRouteOptions.Builder()
                        .pageName("/mainPage")
                        .arguments(arguments)
                        .requestCode(1111)
                        .build()
        );
    }

    public void openFlutterSample(View view) {
        HashMap<String, Object> arguments = new HashMap<>();
        arguments.put("data", "from Native");
        FlutterBoost.instance().open(
                new FlutterBoostRouteOptions.Builder()
                        .pageName("/simplePage")
                        .arguments(arguments)
                        .requestCode(1111)
                        .build()

        );
    }

    public void openWeb(View view) {
        Intent intent = new Intent(this, WebActivity.class);
        intent.setData(Uri.parse("/h5?url=js-call-native.html"));
        startActivity(intent);
    }
}