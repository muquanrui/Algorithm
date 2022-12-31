package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/10/20 22:01
 */

public class LeetCode0779 {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int last = kthGrammar(n - 1, (k + 1) / 2);
        if (k % 2 == 1) {
            return last;
        } else {
            return last ^ 1;
        }
    }
}
