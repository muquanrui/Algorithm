package ink.vor.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/7 22:30
 */
public class LeetCode0131 {
    List<List<String>>  resList = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return resList;
    }
    private void backtracking(String s, int start) {
        if (start == s.length()) {
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            String sub = s.substring(start, end + 1);
            if (isPalindrome(sub)) {
                list.addLast(sub);
                backtracking(s, end + 1);
                list.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
