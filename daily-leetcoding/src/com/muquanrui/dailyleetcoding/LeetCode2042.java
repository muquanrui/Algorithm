package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/3 00:04
 */

public class LeetCode2042 {
    public boolean areNumbersAscending(String s) {
        int i = 0;
        int preNum = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                i++;
                continue;
            }
            int curNum = 0;
            while (ch >= '0' && ch <= '9') {
                curNum = curNum * 10 + (ch - '0');
                i++;
                if (i >= s.length()) {
                    break;
                }
                ch = s.charAt(i);
            }
            if (curNum <= preNum) {
                return false;
            }
            preNum = curNum;
        }
        return true;
    }
}
