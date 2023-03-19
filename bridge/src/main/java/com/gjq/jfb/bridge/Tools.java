package com.gjq.jfb.bridge;

/**
 * @author: JackyG - 顾家齐
 * @program: JS-Flutter-Bridge
 * <p>
 * Wechat&Phone: 17603065766
 * @email: 595713033@qq.com
 * @create: 2023-03-18 22:04
 * @description:
 **/
public class Tools {

    public static String[] parseNamespace(String method) {
        int pos = method.lastIndexOf('.');
        String namespace = "";
        if (pos != -1) {
            namespace = method.substring(0, pos);
            method = method.substring(pos + 1);
        }
        return new String[]{namespace, method};
    }
}
