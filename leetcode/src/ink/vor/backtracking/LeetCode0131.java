package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 04/03/2022 19:18
 */
public class LeetCode0131 {
    private List<List<String>> resList = new ArrayList<>();
    private LinkedList<String> list = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return resList;
    }

    private void backtracking(String s, int start) {
        if (start == s.length()) {
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (isPalindrome(str)) {
                list.addLast(str);
                backtracking(s, i + 1);
                list.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
