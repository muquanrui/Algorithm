package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/5 23:07
 */

public class LeetCode1803 {
    Trie root;

    public int countPairs(int[] nums, int low, int high) {
        return get(nums, high) - get(nums, low - 1);
    }

    int get(int[] nums, int high) {
        root = new Trie();
        int ans = 0;
        for (int num : nums) {
            ans += query(num, high);
            add(num);
        }
        return ans;
    }

    void add(int x) {
        Trie p = root;
        for (int i = 14; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (p.trie[u] == null) {
                p.trie[u] = new Trie();
            }
            p = p.trie[u];
            p.cnt++;
        }
    }

    int query(int x, int high) {
        int sum = 0;
        Trie p = root;
        for (int i = 14; i >= 0; i--) {
            int xi = (x >> i) & 1;
            if (((high >> i) & 1) == 1) {
                if (p.trie[xi] != null) {
                    sum += p.trie[xi].cnt;
                }
                if (p.trie[xi ^ 1] == null) {
                    return sum;
                }
                p = p.trie[xi ^ 1];
            } else {
                if (p.trie[xi] == null) {
                    return sum;
                }
                p = p.trie[xi];
            }
        }
        sum += p.cnt;
        return sum;
    }

}

class Trie {
    Trie[] trie = new Trie[2];
    int cnt;
}
