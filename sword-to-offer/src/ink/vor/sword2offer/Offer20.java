package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/22 17:43
 */
public class Offer20 {
    public boolean isNumber(String s) {
        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        int end = s.length();
        while (end > start && s.charAt(end - 1) == ' ') {
            end--;
        }
        if (start == end) {
            return false;
        }
        int e = start;
        while (e < end && s.charAt(e) != 'e' && s.charAt(e) != 'E') {
            e++;
        }
        if (e == end) {
            return isInteger(s.substring(start, end)) || isDouble(s.substring(start, end));
        } else if (e == end - 1 || e == start){
            return false;
        } else {
            return (isInteger(s.substring(start, e)) || isDouble(s.substring(start, e)))
                    &&  isInteger(s.substring(e + 1, end));
        }
    }

    private boolean isInteger(String s) {
        int index = 0;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            index++;
            if (index == s.length()) {
                return false;
            }
        }
        while (index < s.length()) {
            if (s.charAt(index) < '0' || s.charAt(index) > '9') {
                return false;
            }
            index++;
        }
        return true;
    }

    private boolean isDouble(String s) {
        int index = 0;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            index++;
            if (index == s.length()) {
                return false;
            }
        }
        if (s.charAt(index) == '.') {
            index++;
            if (index == s.length()) {
                return false;
            }
            while (index < s.length()) {
                if (s.charAt(index) < '0' || s.charAt(index) >'9') {
                    return false;
                }
                index++;
            }
        } else {
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                index++;
            }
            if (index == s.length() || s.charAt(index) != '.') {
                return false;
            }
            index++;
            while (index < s.length()) {
                if (s.charAt(index) < '0' || s.charAt(index) >'9') {
                    return false;
                }
                index++;
            }
        }
        return true;
    }
}
