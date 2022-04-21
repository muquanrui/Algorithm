package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/21 14:54
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }
}
