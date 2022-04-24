package ink.vor.sword2offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/4/24 15:04
 */
public class Offer38 {
    private LinkedList<String> resList = new LinkedList<>();
    private StringBuilder sb = new StringBuilder();
    private boolean[] isVisited;
    public String[] permutation(String s) {
        isVisited = new boolean[s.length()];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        backtracking(arr);
        String[] res = new String[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.getFirst();
            resList.removeFirst();
        }
        return res;
    }

    private void backtracking(char[] arr) {
        if (sb.length() == arr.length) {
            resList.addLast(new String(sb));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (isVisited[i] || (i > 0 && arr[i] == arr[i - 1] && !isVisited[i - 1])) {
                continue;
            }
            isVisited[i] = true;
            sb.append(arr[i]);
            backtracking(arr);
            sb.deleteCharAt(sb.length() - 1);
            isVisited[i] = false;
        }
    }
}
