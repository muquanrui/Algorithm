package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/21 14:53
 */
public class Offer13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] isVisited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (getSum(i) + getSum(j) > k) {
                    continue;
                }
                if (i > 0 && j > 0) {
                    isVisited[i][j] = isVisited[i - 1][j] || isVisited[i][j - 1];
                } else if (i > 0) {
                    isVisited[i][j] = isVisited[i - 1][j];
                } else if (j > 0){
                    isVisited[i][j] = isVisited[i][j - 1];
                } else {
                    isVisited[i][j] = true;
                }
                res = isVisited[i][j] ? res + 1 : res;
            }
        }
        return res;
    }

    private int getSum(int x) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
