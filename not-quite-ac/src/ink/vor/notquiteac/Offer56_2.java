package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/20 20:26
 */
public class Offer56_2 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int n : nums) {
            int cur = n;
            for (int i = 0; i < 32; i++) {
                count[i] += (cur & 1);
                cur >>>= 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= count[i] % 3;
        }
        return res;
    }
}
