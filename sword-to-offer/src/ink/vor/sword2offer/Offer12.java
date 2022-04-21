package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/21 14:53
 */
public class Offer12 {
    boolean[][] isVisited;
    public boolean exist(char[][] board, String word) {
        isVisited = new boolean[board.length][board[0].length];
        char ch = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ch && exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, String word, int i) {
        if (i == word.length() - 1) {
            return true;
        }
        isVisited[y][x] = true;
        char ch = word.charAt(i + 1);
        boolean isFind = false;
        if (x < board[0].length - 1 && !isVisited[y][x + 1] && board[y][x + 1] == ch) {
            isFind = exist(board, y, x + 1, word, i + 1);
        }
        if (!isFind && y < board.length - 1 && !isVisited[y + 1][x] && board[y + 1][x] == ch) {
            isFind = exist(board, y + 1, x, word, i + 1);
        }
        if (!isFind && x > 0 && !isVisited[y][x - 1] && board[y][x - 1] == ch) {
            isFind = exist(board, y, x - 1, word, i + 1);
        }
        if (!isFind && y > 0 && !isVisited[y - 1][x] && board[y - 1][x] == ch) {
            isFind = exist(board, y - 1, x, word, i + 1);
        }
        isVisited[y][x] = false;
        return isFind;
    }
}
