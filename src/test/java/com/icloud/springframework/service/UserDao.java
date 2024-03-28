package com.icloud.springframework.service;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String,String> map = new HashMap<>();

    static {
        map.put("1","小李");
        map.put("2","小王");
        map.put("3","小孙");
    }

    public String findNameById(String id){
        return map.get(id);
    }
}
