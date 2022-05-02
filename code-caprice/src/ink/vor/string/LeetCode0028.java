package ink.vor.string;

/**
 * @author muquanrui
 * @date 2022/5/2 16:40
 */
public class LeetCode0028 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] prefixTable = getPrefixTable(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = prefixTable[j - 1];
            }
            if (haystack.charAt(i) != needle.charAt(j)) {
                continue;
            }
            j++;
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] getPrefixTable(String s) {
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
        return prefixTable;
    }
}
