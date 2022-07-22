package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/22 09:55
 */
public class Offer58_1 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int right = s.length() - 1;
        int left = right;
        while (left >= 0) {
            if (s.charAt(left) == ' ') {
                left--;
                right = left;
                continue;
            }
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            sb.append(s.substring(left + 1, right + 1) + " ");
        }
        return sb.toString().trim();
    }
}
