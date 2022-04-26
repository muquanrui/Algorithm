package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/26 14:28
 */
public class Offer56_2 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int n: nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += n & 1;
                n >>>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= count[31 - i] % 3;
        }
        return res;
    }
}
