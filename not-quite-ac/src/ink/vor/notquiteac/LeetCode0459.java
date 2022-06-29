package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/29 15:23
 */
public class LeetCode0459 {
    public boolean repeatedSubstringPattern(String s) {
        int[] prefixTable = new int[s.length()];
        prefixTable[0] = 0;
        for (int i = 1; i < prefixTable.length; i++) {
            int j = prefixTable[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefixTable[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            prefixTable[i] = j;
        }
        return prefixTable[s.length() - 1] > 0 && s.length() % (s.length() - prefixTable[s.length() - 1]) == 0;
    }
}
