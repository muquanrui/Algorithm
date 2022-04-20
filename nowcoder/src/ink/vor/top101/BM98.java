package ink.vor.top101;

import java.util.ArrayList;

/**
 * @author muquanrui
 * @date 2022/4/20 05:49
 */
public class BM98 {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (top < (matrix.length + 1) / 2 && left < (matrix[0].length + 1) / 2) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            for (int i = right - 1; top != bottom && i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            for (int i = bottom - 1; left != right && i > top; i--) {
                list.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return list;
    }
}
