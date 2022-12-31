package com.muquanrui.dailyleetcoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/10/5 23:45
 */

public class LeetCode0811 {
    public static void main(String[] args) {
        String[] cpdomains = new String[]{"9001 discuss.leetcode.com"};
        subdomainVisits(cpdomains);
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] cur = s.split(" ");
            int count = Integer.parseInt(cur[0]);
            String[] domains = cur[1].split("\\.");
            String tmp = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                tmp = domains[i] + tmp;
                map.put(tmp, map.getOrDefault(tmp, 0) + count);
                tmp = "." + tmp;
            }
        }
        List<String> resList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            resList.add(entry.getValue() + " " + entry.getKey());
        }
        return resList;
    }
}
