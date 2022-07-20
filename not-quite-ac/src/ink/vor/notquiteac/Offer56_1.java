package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/20 14:27
 */
public class Offer56_1 {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        int div = 1;
        while ((div & xor) == 0) {
            div <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ((n & div) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
