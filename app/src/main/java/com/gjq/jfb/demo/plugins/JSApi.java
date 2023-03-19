package com.gjq.jfb.demo.plugins;

import android.webkit.JavascriptInterface;

import wendu.dsbridge.CompletionHandler;

/**
 * @author: JackyG - 顾家齐
 * @program: JS-Flutter-Bridge
 * <p>
 * Wechat&Phone: 17603065766
 * @email: 595713033@qq.com
 * @create: 2023-03-01 15:53
 * @description:
 **/
public class JSApi {
    //for synchronous invocation
    @JavascriptInterface
    public String testSyn(Object msg) {
        return msg + "［syn call］";
    }

    //for asynchronous invocation
    @JavascriptInterface
    public void testAsyn(Object msg, CompletionHandler handler) {
        handler.complete(msg + " [ asyn call]");
    }
}

