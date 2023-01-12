package com.muquanrui.dailyleetcoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2023/1/12 13:33
 */

public class LeetCode1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (ch == '(') {
                sb.append(s.substring(left, right));
                left = right + 1;
            } else if (ch == ')') {
                String key = s.substring(left, right);
                sb.append(map.getOrDefault(key, "?"));
                left = right + 1;
            }
        }
        sb.append(s.substring(left));
        return sb.toString();
    }
}
