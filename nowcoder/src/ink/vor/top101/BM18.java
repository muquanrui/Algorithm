package ink.vor.top101;

/**
 * @author muquanrui
 * @date 03/04/2022 02:36
 */
public class BM18 {
    public boolean Find(int target, int [][] array) {
        int i = array.length - 1;
        int j = 0;
        while (i > -1 && j < array[0].length) {
            int cur = array[i][j];
            if (cur > target) {
                i--;
            } else if (cur < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
