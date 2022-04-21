package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/21 09:02
 */
public class Offer05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s);
        int oldL = sb.length();
        int newL = sb.length();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                newL += 2;
            }
        }
        sb.setLength(newL);
        int oldIndex = oldL - 1;
        int newIndex = newL - 1;
        for (; oldIndex >= 0; oldIndex--) {
            if (sb.charAt(oldIndex) == ' ') {
                sb.setCharAt(newIndex--, '0');
                sb.setCharAt(newIndex--, '2');
                sb.setCharAt(newIndex--, '%');
            } else {
                sb.setCharAt(newIndex--, sb.charAt(oldIndex));
            }
        }
        return sb.toString();
    }
}
