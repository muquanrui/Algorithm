package ink.vor.top100liked;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 06/12/2021 14:24
 */
public class LeetCode0048 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(matrix);
        for (int[] arr: matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int outter = 0; outter < (length + 1) / 2; outter++) {
            for (int inner = outter; inner < length - 1 - outter; inner++) {
                int temp = matrix[outter][inner];
                matrix[outter][inner] = matrix[length - 1 - inner][outter];
                matrix[length - 1 - inner][outter] = matrix[length - 1 - outter][length - 1 - inner];
                matrix[length - 1 - outter][length - 1 - inner] = matrix[inner][length - 1 - outter];
                matrix[inner][length - 1 - outter] = temp;
            }
        }
    }

}
