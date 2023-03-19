package com.gjq.jfb.bridge;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: JackyG - 顾家齐
 * @program: JS-Flutter-Bridge
 * <p>
 * Wechat&Phone: 17603065766
 * @email: 595713033@qq.com
 * @create: 2023-03-18 21:59
 * @description:
 **/
public class PluginManager {
    private Map<String, Object> javaScriptNamespaceInterfaces = new HashMap<String, Object>();

    private static final PluginManager INSTANCE = new PluginManager();

    public static PluginManager getInstance() {
        return INSTANCE;
    }

    /**
     * Add a java object which implemented the javascript interfaces to dsBridge with namespace.
     * Remove the object using {@link #removeJavascriptObject(String) removeJavascriptObject(String)}
     *
     * @param object
     * @param namespace if empty, the object have no namespace.
     */
    public void addJavascriptObject(Object object, String namespace) {
        if (namespace == null) {
            namespace = "";
        }
        if (object != null) {
            javaScriptNamespaceInterfaces.put(namespace, object);
        }
    }

    /**
     * remove the javascript object with supplied namespace.
     *
     * @param namespace
     */
    public void removeJavascriptObject(String namespace) {
        if (namespace == null) {
            namespace = "";
        }
        javaScriptNamespaceInterfaces.remove(namespace);

    }

    public Object getPlugin(String namnSpace) {
        return javaScriptNamespaceInterfaces.get(namnSpace);
    }

    public Set<String> getNamespaces() {
        return javaScriptNamespaceInterfaces.keySet();
    }
}
