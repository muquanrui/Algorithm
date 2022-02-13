package ink.vor.string;

/**
 * @author muquanrui
 * @date 13/02/2022 22:32
 */
public class LeetCode0459 {
    public boolean repeatedSubstringPattern(String s) {
        // for (int i = 0; i < s.length() / 2; i++) {
        //     if (s.length() % (i + 1) == 0) {
        //         String match = s.substring(0, i + 1);
        //         int j;
        //         for (j = i + 1; j < s.length(); j += i + 1) {
        //             String toBeMatched = s.substring(j, j + i + 1);
        //             if (!match.equals(toBeMatched)) {
        //                 break;
        //             }
        //         }
        //         if (j == s.length()) {
        //             return true;
        //         }
        //     }
        // }
        // return false;
        int[] prefixTable = new int[s.length()];
        prefixTable[0] = 0;
        for (int i = 1; i < prefixTable.length; i++) {
            int j = prefixTable[i - 1];
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = prefixTable[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                prefixTable[i] = j + 1;
            }
        }
        int len = s.length();
        s.substring(0);
        return prefixTable[len - 1] != 0 && len % (len - prefixTable[len - 1]) == 0;
    }
}
