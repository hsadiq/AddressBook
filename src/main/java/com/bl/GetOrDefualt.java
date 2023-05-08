package com.bl;

import java.util.HashMap;
import java.util.Map;

public class GetOrDefualt {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

// get the value associated with the key "A"
        int value1 = map.getOrDefault("A", 0); // returns 1

// get the value associated with the key "D"
        int value2 = map.getOrDefault("D", 0); // returns 0

    }
}
