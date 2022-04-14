package ink.vor.top101;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/4/14 18:17
 */
public class BM58 {
    ArrayList<String> resList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] isVisited;
    public ArrayList<String> Permutation(String str) {
        isVisited = new boolean[str.length()];
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        backtracking(strArr);
        return resList;
    }
    private void backtracking(char[] strArr) {
        if (sb.length() == strArr.length) {
            resList.add(new String(sb));
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (isVisited[i] || (i > 0 && strArr[i] == strArr[i - 1] && !isVisited[i - 1])) {
                continue;
            }
            isVisited[i] = true;
            sb.append(strArr[i]);
            backtracking(strArr);
            sb.deleteCharAt(sb.length() - 1);
            isVisited[i] = false;
        }
    }
}
