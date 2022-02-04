package ink.vor.array;

/**
 * @author muquanrui
 * @date 04/02/2022 16:35
 */
public class LeetCode0059 {
    int[][] matrix;
    boolean[][] isVisited;
    public int[][] generateMatrix(int n) {
        matrix = new int[n][n];
        isVisited = new boolean[n][n];
        int x = 0;
        int y = -1;
        int i = 1;
        while (i <= n * n) {
            while (y + 1 < n && isVisited[x][y + 1] == false) {
                keepWay(x, ++y, i++);
            }
            while (x + 1 < n && isVisited[x + 1][y] == false) {
                keepWay(++x, y, i++);
            }
            while (y - 1 > -1 && isVisited[x][y - 1] == false) {
                keepWay(x, --y, i++);
            }
            while (x - 1 > -1 && isVisited[x - 1][y] == false){
                keepWay(--x, y, i++);
            }

        }
        return matrix;
    }

    public void keepWay(int x, int y, int i) {
        matrix[x][y] = i;
        isVisited[x][y] = true;
    }
}
