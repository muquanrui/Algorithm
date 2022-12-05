package ink.vor.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2022/12/6 02:45
 */

public class LeetCode1805 {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int left = 0;

        while (left < word.length()) {
            if (Character.isLetter(word.charAt(left))) {
                left++;
                continue;
            }
            int right = left + 1;
            while (right < word.length() && Character.isDigit(word.charAt(right))) {
                right++;
            }
            while (left < right - 1 && word.charAt(left) == '0') {
                left++;
            }
            set.add(word.substring(left, right));
            left = right + 1;
        }

        return set.size();
    }
}
