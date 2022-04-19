package ink.vor.top101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author muquanrui
 * @date 2022/4/19 07:48
 */
public class BM83 {
    public String trans(String s, int n) {
        // write code here
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            int j = i;
            while (j < sb.length() && sb.charAt(i) != ' ' && sb.charAt(j) != ' ') {
                j++;
            }
            int end = j;
            j--;
            while (i <= j) {
                char charI = sb.charAt(i);
                char charJ = sb.charAt(j);
                sb.setCharAt(i, charJ >= 'a' && charJ <= 'z' ? Character.toUpperCase(charJ) : Character.toLowerCase(charJ));
                sb.setCharAt(j, charI >= 'a' && charI <= 'z' ? Character.toUpperCase(charI) : Character.toLowerCase(charI));
                i++;
                j--;
            }
            i = end;
        }
        return sb.toString();
    }
}
