package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/21 14:55
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int[] res = new int[(int)Math.pow(10, n) - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
