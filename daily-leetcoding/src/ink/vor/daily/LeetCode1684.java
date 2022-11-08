package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/11/8 01:02
 */

// https://leetcode.cn/problems/count-the-number-of-consistent-strings/
public class LeetCode1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] dict = new boolean[26];
        for (char ch : allowed.toCharArray()) {
            dict[ch - 'a'] = true;
        }
        int count = 0;
        for (String word : words) {
            int i = 0;
            for (char ch : word.toCharArray()) {
                if (!dict[ch - 'a']) {
                    break;
                }
                i++;
            }
            count = i == word.length() ? count + 1 : count;
        }
        return count;
    }
}
