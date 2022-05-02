package ink.vor.string;

/**
 * @author muquanrui
 * @date 2022/5/2 16:00
 */
public class Offer05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s);
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        int oldS = s.length() - 1;
        int newS = sb.length() - 1;
        while (oldS >= 0) {
            if (sb.charAt(oldS) == ' ') {
                sb.setCharAt(newS--, '0');
                sb.setCharAt(newS--, '2');
                sb.setCharAt(newS--, '%');
                oldS--;
            } else {
                sb.setCharAt(newS--, sb.charAt(oldS--));
            }
        }
        return sb.toString();
    }
}
