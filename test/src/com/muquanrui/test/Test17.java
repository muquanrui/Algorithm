package com.muquanrui.test;

/**
 * @author muquanrui
 * @date 2022/9/29 19:36
 */

public class Test17 {
    public String get_substr (String st) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == sb.charAt(sb.length() - 1) && sb.charAt(sb.length() - 1) == ch) {
                sb.delete(sb.length() - 2, sb.length());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
