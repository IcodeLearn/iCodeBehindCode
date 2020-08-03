package com.example.demo.utils;


import java.util.HashMap;


public class ResultMap {

    public static HashMap<String, Object> setResult(String customStatus, Object data, String message) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("custom_status", customStatus);
        map.put("data", data);
        map.put("message", message);
        return map;
    }

}
