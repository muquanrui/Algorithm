package com.muquanrui.dailyleetcoding;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
        // [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
        int[][] grid = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1}, {1,1,1,1,1}};
        LeetCode0934 l = new LeetCode0934();
        System.out.println(l.shortestBridge(grid));;
    }

    boolean[][] isVisited;
    Deque<int[]> queue;
    public int shortestBridge(int[][] grid) {
        isVisited = new boolean[grid.length][grid[0].length];
        queue = new LinkedList<>();
        markIsland(grid);
        for (int[] arr : grid) {
            System.out.println(Arrays.toString(arr));
        }
        return bfs(grid);
    }

    private void markIsland(int[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return;
                }
            }
        }
    }

    private void dfs(int[][] grid, int y, int x) {
        if (y > grid.length - 1 || y < 0 || x > grid[0].length - 1 || x < 0 || isVisited[y][x] || grid[y][x] == 0) {
            return;
        }
        isVisited[y][x] = true;
        grid[y][x] = 2;
        queue.offer(new int[]{y, x});
        dfs(grid, y + 1, x);
        dfs(grid, y, x + 1);
        dfs(grid, y - 1, x);
        dfs(grid, y, x - 1);
    }

    private int bfs(int[][] grid) {
        int step = 0;
        while (!queue.isEmpty()) {
            for (int[] arr : queue) {
                System.out.print(Arrays.toString(arr));
            }
            System.out.println();
            int size = queue.size();
            boolean flag = false;
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int y = cur[0];
                int x = cur[1];
                if (grid[y][x] == 1) {
                    return step;
                }
                if (grid[y][x] == 0) {
                    flag = true;
                }
                if (y + 1 < grid.length && !isVisited[y + 1][x]) {
                    isVisited[y + 1][x] = true;
                    queue.offer(new int[]{y + 1, x});
                }
                if (x + 1 < grid[0].length && !isVisited[y][x + 1]) {
                    isVisited[y][x + 1] = true;
                    queue.offer(new int[]{y, x + 1});
                }
                if (y - 1 >= 0 && !isVisited[y - 1][x]) {
                    isVisited[y - 1][x] = true;
                    queue.offer(new int[]{y - 1, x});
                }
                if (x - 1 >= 0 && !isVisited[y][x - 1]) {
                    isVisited[y][x - 1] = true;
                    queue.offer(new int[]{y, x - 1});
                }
            }
            if (flag) {
                step++;
            }
        }
        return -1;
    }
}
