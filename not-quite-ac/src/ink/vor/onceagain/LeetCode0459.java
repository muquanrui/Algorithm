package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/29 15:23
 */

/**
 * https://leetcode.cn/problems/repeated-substring-pattern/
 * KMP算法
 */
public class LeetCode0459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) {
            return true;
        }
        int[] prefixTable = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int j = prefixTable[i - 1];
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = prefixTable[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                prefixTable[i] = j + 1;
            }
        }
        return prefixTable[s.length() - 1] > 0 && s.length() % (s.length() - prefixTable[s.length() - 1]) == 0;
    }
}
