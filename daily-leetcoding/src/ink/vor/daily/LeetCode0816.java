package ink.vor.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/11/7 16:08
 */

public class LeetCode0816 {
    public static void main(String[] args) {
        LeetCode0816 l = new LeetCode0816();
        System.out.println(l.ambiguousCoordinates("(0010)"));;
    }

    public List<String> ambiguousCoordinates(String s) {
        List<String> resList = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            List<String> list1 = addPoint(s1);
            List<String> list2 = addPoint(s2);
            for (String str1 : list1) {
                for (String str2 : list2) {
                    resList.add("(" + str1 + ", " + str2 + ")");
                }
            }
        }
        return resList;
    }

    private List<String> addPoint(String s) {
        List<String> list = new ArrayList<>();
        if (isValid1(s)) {
            list.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            if (isValid1(s1) && isValid2(s2)) {
                list.add(s1 + "." + s2);
            }
        }
        return list;
    }

    private boolean isValid1(String s) {
        return s.charAt(0) == '0' ? s.length() == 1 : true;
    }

    private boolean isValid2(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                int j = i;
                for (; j < s.length(); j++) {
                    if (s.charAt(j) != '0') {
                        break;
                    }
                }
                if (j == s.length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
