package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/14 17:59
 */
public class BM57 {
    private boolean[][] isVisited;
    private int count = 0;

    public int solve (char[][] grid) {
        isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!isVisited[i][j] && grid[i][j] == '1') {
                    count++;
                    search(grid, i, j);
                }
            }
        }
        return count;
    }

    private void search(char[][] grid, int i, int j) {
        isVisited[i][j] = true;
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1' && !isVisited[i][j + 1]) {
            search(grid, i, j + 1);
        }
        if (j > 0 && grid[i][j - 1] == '1' && !isVisited[i][j - 1]) {
            search(grid, i, j - 1);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1' && !isVisited[i + 1][j]) {
            search(grid, i + 1, j);
        }
        if (i > 0 && grid[i - 1][j] == '1' && !isVisited[i - 1][j]) {
            search(grid, i - 1, j);
        }
    }
}
