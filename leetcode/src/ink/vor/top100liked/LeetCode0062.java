package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 08/12/2021 19:08
 */
public class LeetCode0062 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] grids = new int[m][n];
        dfs(m - 1, n - 1, grids);
        return grids[m - 1][n - 1];
    }

    public static int dfs(int m, int n, int[][] grids) {
        if (m == 0 || n == 0) {
            grids[m][n] = 1;
            return 1;
        }
        if (grids[m][n] == 0) {
            grids[m][n] = dfs(m - 1, n, grids) + dfs(m, n - 1, grids);
        }
        return grids[m][n];
    }
}
