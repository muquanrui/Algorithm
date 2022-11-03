package ink.vor.daily;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/11/3 15:26
 */

public class LeetCode1668 {
    public static void main(String[] args) {
        LeetCode1668 l = new LeetCode1668();
        l.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba");
    }

    public int maxRepeating(String sequence, String word) {
        int[] prefixTable = getPrefixTable(word);
        int[] dp = new int[sequence.length()];
        int k = 0;
        for (int i = 0; i < sequence.length(); i++) {
            int start = getMatchStart(sequence, word, prefixTable, i);
            if (start == -1) {
                break;
            }
            int end = start + word.length() - 1;
            if (end - word.length() >= 0) {
                dp[end] = dp[end - word.length()] + 1;
            } else {
                dp[end] = 1;
            }
            k = Math.max(k, dp[end]);
        }
        return k;
    }

    private int getMatchStart(String sequence, String word, int[] prefixTable, int start) {
        int j = 0;
        for (int i = start; i < sequence.length(); i++) {
            while (j > 0 && sequence.charAt(i) != word.charAt(j)) {
                j = prefixTable[j - 1];
            }
            if (sequence.charAt(i) == word.charAt(j)) {
                j++;
            }
            if (j == word.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] getPrefixTable(String s) {
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
        return prefixTable;
    }
}
