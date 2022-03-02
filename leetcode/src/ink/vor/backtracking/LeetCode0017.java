package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author muquanrui
 * @date 02/03/2022 23:34
 */
public class LeetCode0017 {
    StringBuilder sb = new StringBuilder();
    HashMap<Integer, String> map = new HashMap<>();
    List<String> resList = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        letterCombinations(digits, 0);
        return resList;
    }

    public void letterCombinations(String digits, int i) {
        if (i == digits.length()) {
            if (sb.length() > 0) {
                resList.add(sb.toString());
            }
            return;
        }
        String letters = map.get(Character.getNumericValue(digits.charAt(i)));
        for (char ch: letters.toCharArray()) {
            sb.append(ch);
            letterCombinations(digits, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
