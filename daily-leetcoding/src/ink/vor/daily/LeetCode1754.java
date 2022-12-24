package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/12/24 12:59
 */

public class LeetCode1754 {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i1 = 0;
        int i2 = 0;
        while (i1 < word1.length() && i2 < word2.length()) {
            if (word1.substring(i1).compareTo(word2.substring(i2)) > 0) {
                sb.append(word1.charAt(i1++));
            } else {
                sb.append(word2.charAt(i2++));
            }
        }
        if (i1 < word1.length()) {
            sb.append(word1.substring(i1));
        } else {
            sb.append(word2.substring(i2));
        }
        return sb.toString();
    }
}
