package ink.vor.hashtable;

/**
 * @author muquanrui
 * @date 2022/5/2 11:37
 */
public class LeetCode0242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] tableS = new int[26];
        int[] tableT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            tableS[s.charAt(i) - 'a'] += 1;
            tableT[t.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (tableS[i] != tableT[i]) {
                return false;
            }
        }
        return true;
    }
}
