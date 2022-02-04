package ink.vor.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 04/02/2022 17:09
 */
public class LeetCode0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int maxNo = rows * columns;
        boolean[][] isVisited = new boolean[rows][columns];
        int index = 1;
        int x = 0;
        int y = -1;
        while (index <= maxNo) {
            while (y + 1 < columns && isVisited[x][y + 1] == false) {
                isVisited[x][++y] = true;
                resList.add(matrix[x][y]);
                index++;
            }
            while (x + 1 < rows && isVisited[x + 1][y] == false) {
                isVisited[++x][y] = true;
                resList.add(matrix[x][y]);
                index++;
            }
            while (y - 1 > -1 && isVisited[x][y - 1] == false) {
                isVisited[x][--y] = true;
                resList.add(matrix[x][y]);
                index++;
            }
            while (x - 1 > -1 && isVisited[x - 1][y] == false) {
                isVisited[--x][y] = true;
                resList.add(matrix[x][y]);
                index++;
            }
        }
        return resList;
    }
}
