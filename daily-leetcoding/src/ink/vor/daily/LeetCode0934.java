package ink.vor.daily;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/10/25 23:01
 */

public class LeetCode0934 {
    // 0,0,1,0,1
    // 0,1,1,0,1
    // 0,1,0,0,1
    // 0,0,0,0,0
    // 0,0,0,0,0
    public static void main(String[] args) {
        // [[0,1,0,0,0],[0,1,0,1,1],[0,0,0,0,1],[0,0,0,0,0],[0,0,0,0,0]]
        int[][] grid = {{0,1,0,0,0},{0,1,0,1,1},{0,0,0,0,1},{0,0,0,0,0}};
        LeetCode0934 l = new LeetCode0934();
        System.out.println(l.shortestBridge(grid));;
    }


    boolean[][] isVisited;
    public int shortestBridge(int[][] grid) {
        isVisited = new boolean[grid.length][grid[0].length];
        markIsland(grid);

        for (int[] arr : grid) {
            System.out.println(Arrays.toString(arr));
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    isVisited = new boolean[grid.length][grid[0].length];
                    res = Math.min(res, tryConnect(grid, i, j) - 1);
                }
            }
        }
        return res;
    }

    private void markIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    markIsland(grid, i, j, 2);
                    return;
                }
            }
        }
    }

    private void markIsland(int[][] grid, int y, int x, int mark) {
        isVisited[y][x] = true;
        grid[y][x] = mark;
        if (y + 1 < grid.length && !isVisited[y + 1][x] && grid[y + 1][x] == 1) {
            markIsland(grid, y + 1, x, mark);
        }
        if (x + 1 < grid[0].length && !isVisited[y][x + 1] && grid[y][x + 1] == 1) {
            markIsland(grid, y, x + 1, mark);
        }
        if (y - 1 >= 0 && !isVisited[y - 1][x] && grid[y - 1][x] == 1) {
            markIsland(grid, y - 1, x, mark);
        }
        if (x - 1 >= 0 && !isVisited[y][x - 1] && grid[y][x - 1] == 1) {
            markIsland(grid, y, x - 1, mark);
        }
    }

    private int tryConnect(int[][] grid, int y, int x) {
        if (grid[y][x] == 1) {
            return 0;
        }
        isVisited[y][x] = true;
        int min = Integer.MAX_VALUE - 1;
        if (y + 1 < grid.length && !isVisited[y + 1][x] && grid[y + 1][x] != 2) {
            min = Math.min(min, tryConnect(grid, y + 1, x));
        }
        if (x + 1 < grid[0].length && !isVisited[y][x + 1] && grid[y][x + 1] != 2) {
            min = Math.min(min, tryConnect(grid, y, x + 1));
        }
        if (y - 1 >= 0 && !isVisited[y - 1][x] && grid[y - 1][x] != 2) {
            min = Math.min(min, tryConnect(grid, y - 1, x));
        }
        if (x - 1 >= 0 && !isVisited[y][x - 1] && grid[y][x - 1] != 2) {
            min = Math.min(min, tryConnect(grid, y, x - 1));
        }
        isVisited[y][x] = false;
        return min + 1;
    }
}
