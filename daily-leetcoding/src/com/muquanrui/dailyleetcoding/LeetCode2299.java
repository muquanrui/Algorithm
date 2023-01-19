package com.muquanrui.dailyleetcoding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2023/1/19 12:03
 */

public class LeetCode2299 {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        Set<Character> set = new HashSet<>(Arrays.asList(new Character[]{'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'}));
        int mask = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (i > 0 && ch == password.charAt(i - 1)) {
                return false;
            }
            if (Character.isLowerCase(ch)) {
                mask |= 1;
            } else if (Character.isUpperCase(ch)) {
                mask |= 2;
            } else if (Character.isDigit(ch)) {
                mask |= 4;
            } else if (set.contains(ch)){
                mask |= 8;
            }
        }
        return mask == 15;
    }
}
