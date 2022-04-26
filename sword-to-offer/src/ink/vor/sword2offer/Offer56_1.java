package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/26 14:28
 */
public class Offer56_1 {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int n: nums) {
            xor ^= n;
        }
        int div = 1;
        while ((xor & div) == 0) {
            div <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int n: nums) {
            if ((div & n) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
