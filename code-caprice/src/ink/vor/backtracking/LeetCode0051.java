package ink.vor.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/9 11:27
 */
public class LeetCode0051 {
    List<List<String>> resList = new LinkedList<>();
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        backtracking(0, n);
        return resList;
    }

    private void backtracking(int row, int n) {
        if (row == n) {
            List<String> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            resList.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!judge(row, j, n)) {
                continue;
            }
            board[row][j] = true;
            backtracking(row + 1, n);
            board[row][j] = false;
        }
    }

    private boolean judge(int row, int column, int n) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][column]) {
                return false;
            }
        }
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }
}
