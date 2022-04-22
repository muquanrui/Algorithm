package ink.vor.sword2offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/4/22 17:45
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
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
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
