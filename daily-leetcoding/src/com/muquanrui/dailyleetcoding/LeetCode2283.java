package com.muquanrui.dailyleetcoding;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2023/1/11 02:20
 */

public class LeetCode2283 {
    public boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (char ch : num.toCharArray()) {
            int key = ch - '0';
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < num.length(); i++) {
            if (map.getOrDefault(i, 0) != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }
}
