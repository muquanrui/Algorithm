package com.muquanrui.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/9/29 19:40
 */

public class Test18 {
    public String substr (String a, String b) {
        if (a == null || b == null || !(a instanceof String) || !(b instanceof String) ) {
            return "";
        }
        // write code here
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : b.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        String res = "";
        int minLength = Integer.MAX_VALUE;
        int countValid = 0;
        for (int right = 0; right < a.length(); right++) {
            char ch = a.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) >= 0) {
                countValid++;
            }
            while (left < a.length() && countValid == b.length()) {
                if (right - left + 1 < minLength) {
                    res = a.substring(left, right + 1);
                    minLength = right - left + 1;
                }
                char cur = a.charAt(left++);
                map.put(cur, map.get(cur) + 1);
                if (map.get(cur) > 0) {
                    countValid--;
                }
            }
        }
        return res;
    }
}
