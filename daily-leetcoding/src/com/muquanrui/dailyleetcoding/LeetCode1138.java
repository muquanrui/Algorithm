package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/2/12 15:22
 */

public class LeetCode1138 {
    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        for (int k = 0; k < target.length(); ++k) {
            int v = target.charAt(k) - 'a';
            int x = v / 5, y = v % 5;
            while (j > y) {
                j--;
                ans.append('L');
            }
            while (i > x) {
                i--;
                ans.append('U');
            }
            while (j < y) {
                j++;
                ans.append('R');
            }
            while (i < x) {
                i++;
                ans.append('D');
            }
            ans.append("!");
        }
        return ans.toString();
    }
}
