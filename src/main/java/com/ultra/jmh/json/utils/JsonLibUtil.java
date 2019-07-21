package com.ultra.jmh.json.utils;

import java.util.Map;

import net.sf.json.JSONObject;

public class JsonLibUtil {

    public static String bean2Json(Object obj) {
        JSONObject jsonObject = JSONObject.fromObject(obj);
        return jsonObject.toString();
    }

    @SuppressWarnings("unchecked")
    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        return (T) JSONObject.toBean(JSONObject.fromObject(jsonStr), objClass);
    }

    @SuppressWarnings("unchecked")
    public static <T> T json2Bean(String jsonStr, Class<T> objClass, Map<String, Class<?>> classMap) {
        return (T) JSONObject.toBean(JSONObject.fromObject(jsonStr), objClass, classMap);
    }
}
