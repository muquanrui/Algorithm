package ink.vor.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 12/02/2022 21:27
 */
public class LeetCode0151 {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) != ' ') {
                StringBuilder sb = new StringBuilder();
                while (index < s.length() && s.charAt(index) != ' ') {
                    sb.append(s.charAt(index));
                    index++;
                }
                list.add(sb.toString());
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i > 0; i--) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        sb.append(list.get(0));
        return sb.toString();
    }
}
