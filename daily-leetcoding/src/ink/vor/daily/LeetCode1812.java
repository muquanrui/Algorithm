package ink.vor.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2022/12/8 00:57
 */

public class LeetCode1812 {
    public boolean squareIsWhite(String coordinates) {
        Set<Character> evenSet = new HashSet<>();
        evenSet.addAll(Arrays.asList('a', 'c', 'e', 'g'));
        Set<Character> oddSet = new HashSet<>();
        oddSet.addAll(Arrays.asList('b', 'd', 'f', 'h'));
        char ch = coordinates.charAt(0);
        int num = coordinates.charAt(1) - '0';
        if (evenSet.contains(ch)) {
            return num % 2 == 0;
        } else {
            return num % 2 != 0;
        }
    }
}
