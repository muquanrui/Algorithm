package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/16 12:38
 */
public class Offer20 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        int point = -1;
        int e = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                continue;
            } else if (ch == '.') {
                if (e == -1 && point == -1 &&
                        ((i > 0 && Character.isDigit(s.charAt(i - 1))) || (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))))) {
                    point = i;
                    continue;
                }
            } else if (ch == 'e' || ch == 'E') {
                if (e == -1 && i > 0 && i < s.length() - 1 && s.charAt(i - 1) != '+' && s.charAt(i - 1) != '-') {
                    e = i;
                    continue;
                }
            } else if (ch == '+' || ch == '-') {
                if (i < s.length() - 1 && (i == 0 || (e != -1 && i == e + 1))) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}
