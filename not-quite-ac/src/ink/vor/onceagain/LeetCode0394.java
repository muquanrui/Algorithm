package ink.vor.onceagain;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/6/27 22:49
 */

/**
 * https://leetcode.cn/problems/decode-string/
 * 字符串，栈
 */
public class LeetCode0394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int repeat = 0;
        Deque<String> strStack = new LinkedList<>();
        Deque<Integer> intStack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                repeat = ch - '0' + repeat * 10;
            } else if (Character.isLowerCase(ch)) {
                res.append(ch);
            } else if (ch == '[') {
                strStack.push(res.toString());
                intStack.push(repeat);
                res = new StringBuilder();
                repeat = 0;
            } else {
                StringBuilder tmp = new StringBuilder();
                int count = intStack.pop();
                for (int j = 0; j < count; j++) {
                    tmp.append(res);
                }
                res = new StringBuilder(strStack.pop() + tmp.toString());
            }
        }
        return res.toString();
    }
}
