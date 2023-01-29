package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/29 15:55
 */

public class LeetCode2315 {
    public int countAsterisks(String s) {
        boolean flag = false;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '|') {
                flag = !flag;
            }
            if (!flag && ch == '*') {
                ans++;
            }
        }
        return ans;
    }
}
