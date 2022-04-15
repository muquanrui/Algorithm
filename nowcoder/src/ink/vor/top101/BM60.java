package ink.vor.top101;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/4/15 15:45
 */
public class BM60 {
    ArrayList<String> resList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int total;
    public ArrayList<String> generateParenthesis (int n) {
        total = n;
        backtracking(0, 0);
        return resList;
    }

    private void backtracking(int leftCount, int rightCount) {
        if (leftCount == total && rightCount == total) {
            resList.add(new String(sb));
            return;
        }
        if (leftCount < total) {
            sb.append("(");
            backtracking(leftCount + 1, rightCount);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightCount < leftCount) {
            sb.append(")");
            backtracking(leftCount, rightCount + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
