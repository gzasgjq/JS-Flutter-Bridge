package com.gjq.jfb.demo.plugins;

import android.util.Log;

import androidx.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.gjq.jfb.demo.plugins.proxy.FakeWebView;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.JSONUtil;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import wendu.dsbridge.InnerJavascriptInterface;
import wendu.dsbridge.PluginManager;

/**
 * @author: JackyG - 顾家齐
 * @program: JS-Flutter-Bridge
 * <p>
 * Wechat&Phone: 17603065766
 * @email: 595713033@qq.com
 * @create: 2023-03-12 15:35
 * @description:
 **/
public class H5BridgePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private final static String NAME_PERFIX = "jsapi/";
    private static final String TAG = "H5BridgePlugin";
    InnerJavascriptInterface innerJavascriptInterface = new InnerJavascriptInterface(new FakeWebView());

    public H5BridgePlugin() {
    }

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        MethodChannel methodChannel = new MethodChannel(binding.getBinaryMessenger(), NAME_PERFIX);
        methodChannel.setMethodCallHandler(this);
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {

    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        Log.d(TAG, "onMethodCall: " + call.method);
        try {
            String argStr = null;
            if (call.arguments != null) {
                argStr = JSON.toJSONString(call.arguments);
            }
            result.success(innerJavascriptInterface.call(call.method, argStr));
        } catch (Exception e) {
            result.error("-1", "js exe error", e.toString());
        }
    }

}
