package com.gjq.jfb.demo;

import android.app.Application;
import android.content.Intent;

import com.gjq.jfb.demo.pages.MainActivity;
import com.gjq.jfb.demo.plugins.H5BridgePlugin;
import com.gjq.jfb.demo.plugins.JSApi;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostDelegate;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;

import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import wendu.dsbridge.PluginManager;

/**
 * @author: JackyG - 顾家齐
 * @program: JS-Flutter-Bridge
 * <p>
 * Wechat&Phone: 17603065766
 * @email: 595713033@qq.com
 * @create: 2023-03-01 18:23
 * @description:
 **/
public class MainApplication extends Application {
    public static final String PAGE_MAIN = "/main";

    @Override
    public void onCreate() {
        super.onCreate();
        PluginManager.getInstance().addJavascriptObject(new JSApi(), "demo");
        FlutterBoost.instance().setup(this, new FlutterBoostDelegate() {
            @Override
            public void pushNativeRoute(FlutterBoostRouteOptions options) {
                //这里根据options.pageName来判断你想跳转哪个页面，这里简单给一个
                String pageName = options.pageName();
                Class<?> targetClass = null;
                switch (pageName) {
                    case PAGE_MAIN:
                        targetClass = MainActivity.class;
                        break;
                }
                if (targetClass == null) {
                    return;
                }
                Intent intent = new Intent(FlutterBoost.instance().currentActivity(), targetClass);
                FlutterBoost.instance().currentActivity().startActivityForResult(intent, options.requestCode());
            }

            @Override
            public void pushFlutterRoute(FlutterBoostRouteOptions options) {
                Intent intent = new FlutterBoostActivity.CachedEngineIntentBuilder(FlutterBoostActivity.class)
                        .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                        .destroyEngineWithActivity(false)
                        .uniqueId(options.uniqueId())
                        .url(options.pageName())
                        .urlParams(options.arguments())
                        .build(FlutterBoost.instance().currentActivity());
                FlutterBoost.instance().currentActivity().startActivity(intent);
            }
        }, engine -> {
            engine.getPlugins().add(new H5BridgePlugin());
        });
    }
}
