package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/5/7 22:29
 */
public class LeetCode0017 {
    Map<Integer, char[]> map = new HashMap<>();
    List<String> resList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return resList;
        }
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
        backtracking(digits, 0);
        return resList;
    }

    private void backtracking(String digits, int index) {
        if (index == digits.length()) {
            resList.add(new String(sb));
            return;
        }
        char[] chars = map.get(digits.charAt(index) - '0');
        for (char ch: chars) {
            sb.append(ch);
            backtracking(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
