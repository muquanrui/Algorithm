package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/11 19:07
 */
public class Offer15 {
    public int hammingWeight(int n) {
        // int count = 0;
        // while (n != 0) {
        //     if ((n & 1) == 1) {
        //         count++;
        //     }
        //     n >>>= 1;
        // }
        // return count;
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
