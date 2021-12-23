package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 23/12/2021 21:21
 */
public class LeetCode0200 {
    public int[][] isVisited;
    public int numIslands(char[][] grid) {
        isVisited = new int[grid.length][grid[0].length];
        int countIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && isVisited[i][j] == 0) {
                    countIslands++;
                    dfs(i, j, grid);
                }
            }
        }
        return countIslands;
    }

    public void dfs(int i, int j, char[][] grid) {
        isVisited[i][j] = 1;
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1' && isVisited[i][j + 1] == 0) {
            dfs(i, j + 1, grid);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1' && isVisited[i + 1][j] == 0) {
            dfs(i + 1, j, grid);
        }
        if (j - 1 > -1 && grid[i][j - 1] == '1' && isVisited[i][j - 1] == 0) {
            dfs(i, j - 1, grid);
        }
        if (i - 1 > -1 && grid[i - 1][j] == '1' && isVisited[i - 1][j] == 0) {
            dfs(i - 1, j, grid);
        }
    }
}
