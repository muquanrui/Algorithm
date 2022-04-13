package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/13 17:56
 */
public class BM52 {
    public int[] FindNumsAppearOnce (int[] array) {
        int judge = array[0];
        for (int i = 1; i < array.length; i++) {
            judge ^= array[i];
        }
        judge &= -judge;
        int[] res = new int[2];
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & judge) == 0) {
                res[0] ^= array[i];
            } else {
                res[1] ^= array[i];
            }
        }
        if (res[0] > res[1]) {
            int temp = res[1];
            res[1] = res[0];
            res[0] = temp;
        }
        return res;
    }
}
