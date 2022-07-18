package ink.vor.notquiteac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2022/7/18 11:40
 */
public class Offer38 {
    List<String> resList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] isVisited;
    public String[] permutation(String s) {
        isVisited = new boolean[s.length()];
        backtracking(s);
        String[] res = resList.toArray(new String[0]);
        return res;
    }
    private void backtracking(String s) {
        if (sb.length() == s.length()) {
            resList.add(sb.toString());
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (isVisited[i] || set.contains(s.charAt(i))) {
                continue;
            }
            set.add(s.charAt(i));
            isVisited[i] = true;
            sb.append(s.charAt(i));
            backtracking(s);
            sb.deleteCharAt(sb.length() - 1);
            isVisited[i] = false;
        }
    }
}
