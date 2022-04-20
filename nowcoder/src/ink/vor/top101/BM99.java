package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/20 06:59
 */
public class BM99 {
    public int[][] rotateMatrix(int[][] mat, int n) {
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n / 2; i++) {
            for (int x = left; x < right; x++) {
                int diff = x - left;
                int temp = mat[top][x];
                mat[top][x] = mat[bottom - diff][left];
                mat[bottom - diff][left] = mat[bottom][right - diff];
                mat[bottom][right - diff] = mat[top + diff][right];
                mat[top + diff][right] = temp;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return mat;
    }
}
