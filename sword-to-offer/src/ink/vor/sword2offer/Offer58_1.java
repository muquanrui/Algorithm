package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/27 15:07
 */
public class Offer58_1 {
    public String reverseWords(String s) {
        s.trim();
        StringBuilder sb = new StringBuilder();
        int right = s.length() - 1;
        int left = right;
        while (left >= 0) {
            while (left >=0 && s.charAt(left) != ' ') {
                left--;
            }
            sb.append(s.substring(left + 1, right + 1) + " ");
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;
        }
        return sb.toString().trim();
    }
}
