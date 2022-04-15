package ink.vor.top101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/4/15 15:12
 */
public class BM59 {
    public int Nqueen (int n) {
        return solveNQueens(n).size();
    }

    List<List<String>> resList = new ArrayList<>();
    char[][] checkboard;
    int length;
    public List<List<String>> solveNQueens(int n) {
        length = n;
        checkboard = new char[n][n];
        for (char[] ch: checkboard) {
            Arrays.fill(ch, '.');
        }
        setQueen(0);
        return resList;
    }

    private void setQueen(int i) {
        if (i == length) {
            List<String> list = new ArrayList<>();
            for (char[] str: checkboard) {
                list.add(new String(str));
            }
            resList.add(list);
            return;
        }
        for (int x = 0; x < length; x++) {
            if (isValid(i, x)) {
                checkboard[i][x] = 'Q';
                setQueen(i + 1);
                checkboard[i][x] = '.';
            }
        }
    }

    private boolean isValid(int i, int j) {
        for (int y = i - 1; y >= 0; y--) {
            if (checkboard[y][j] == 'Q') {
                return false;
            }
        }
        for (int y = i - 1, x = j - 1; x >= 0 && y >= 0; x--, y--) {
            if (checkboard[y][x] == 'Q') {
                return false;
            }
        }
        for (int y = i - 1, x = j + 1; x < length && y >= 0; x++, y--) {
            if (checkboard[y][x] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
