package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/10/1 21:30
 */

public class LeetCode1694 {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch == '-' || ch == ' ') {
                continue;
            }
            sb.append(ch);
        }
        String s = sb.toString();
        if (s.length() <= 3) {
            return s;
        }
        int remainder = sb.length() % 3;
        sb = new StringBuilder();
        for (int i = 0; i < s.length() - remainder; i += 3) {
            sb.append(s.substring(i, i + 3) + "-");
        }
        if (remainder == 0) {
            sb.deleteCharAt(sb.length() - 1);
        } else if (remainder == 1) {
            sb.delete(sb.length() - 3, sb.length());
            sb.append(s.substring(s.length() - 4, s.length() - 2) + "-" + s.substring(s.length() - 2, s.length()));
        } else {
            sb.append(s.substring(s.length() - 2, s.length()));
        }
        return sb.toString();
    }
}
