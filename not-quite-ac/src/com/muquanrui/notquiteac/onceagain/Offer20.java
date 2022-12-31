package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/16 12:38
 */

/**
 * https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * 字符串
 */
public class Offer20 {
    public static void main(String[] args) {
        System.out.println(isNumber(".e1"));
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        int iEe = -1;
        int iDot = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                continue;
            }
            if ((ch == '+' || ch == '-') && (i - 1 == iEe) && i < s.length() - 1) {
                continue;
            }
            if ((ch == 'E' || ch == 'e') && iEe == -1 && i > 0 && i < s.length() - 1 && s.charAt(i - 1) != '+' && s.charAt(i - 1) != '-') {
                iEe = i;
                continue;
            }
            if (ch == '.' && iDot == -1 && iEe == -1 && ((i > 0 && Character.isDigit(s.charAt(i - 1))) || (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))))) {
                iDot = i;
                continue;
            }
            return false;
        }
        return true;
    }
}
