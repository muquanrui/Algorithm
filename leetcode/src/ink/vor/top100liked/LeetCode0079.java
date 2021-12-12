package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 12/12/2021 11:32
 */
public class LeetCode0079 {
    public static void main(String[] args) {
        char[][] borad = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(borad, word));
    }

    public static boolean flag;
    public static int[][] visited;

    public static boolean exist(char[][] board, String word) {
        flag = false;
        visited = new int[board.length][board[0].length];
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wordArr[0]) {
                    recursiveFind(board, wordArr, 0, i, j);
                    if (flag) {
                        return flag;
                    }
                }
            }
        }
        return flag;
    }

    public static void recursiveFind(char[][] board, char[] wordArr, int index, int x, int y) {
        visited[x][y] = 1;
        index++;
        if (index == wordArr.length) {
            flag = true;
            return;
        }
        if (!flag && x - 1 > -1 && visited[x - 1][y] == 0 && board[x - 1][y] == wordArr[index]) {
            recursiveFind(board, wordArr, index, x - 1, y);
        }
        if (!flag && y + 1 < board[0].length && visited[x][y + 1] == 0 && board[x][y + 1] == wordArr[index]) {
            recursiveFind(board, wordArr, index, x, y + 1);
        }
        if (!flag && x + 1 < board.length && visited[x + 1][y] == 0 && board[x + 1][y] == wordArr[index]) {
            recursiveFind(board, wordArr, index, x + 1, y);
        }
        if (!flag && y - 1 > -1 && visited[x][y - 1] == 0 && board[x][y - 1] == wordArr[index]) {
            recursiveFind(board, wordArr, index, x, y - 1);
        }
        visited[x][y] = 0;
    }
}
