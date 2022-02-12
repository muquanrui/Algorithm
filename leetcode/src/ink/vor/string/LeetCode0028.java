package ink.vor.string;

/**
 * @author muquanrui
 * @date 12/02/2022 22:03
 */
public class LeetCode0028 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] prefixTable = getPrefixTable(needle);
        int j = 0;
        for (int i= 0; i < haystack.length(); i++) {
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

    public int[] getPrefixTable(String str) {
        int[] table = new int[str.length()];
        table[0] = 0;
        for (int i = 1; i < table.length; i++) {
            int j = table[i - 1];
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = table[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            table[i] = j;
        }
        return table;
    }
}
