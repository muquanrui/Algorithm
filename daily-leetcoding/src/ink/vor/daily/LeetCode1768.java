package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/10/23 10:52
 */

public class LeetCode1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i1 = 0;
        int i2 = 0;
        while (i1 < word1.length() && i2 < word2.length()) {
            sb.append(word1.charAt(i1++));
            sb.append(word2.charAt(i2++));
        }
        if (i1 < word1.length()) {
            sb.append(word1.substring(i1));
        }
        if (i2 < word2.length()) {
            sb.append(word2.substring(i2));
        }
        return sb.toString();
    }
}
