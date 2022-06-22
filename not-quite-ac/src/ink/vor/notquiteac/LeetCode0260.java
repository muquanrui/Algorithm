package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/22 19:27
 */
public class LeetCode0260 {
    public int[] singleNumber(int[] nums) {
        int axorb = 0;
        for (int i : nums) {
            axorb ^= i;
        }
        axorb &= -axorb;
        int[] res = new int[2];
        for (int i : nums) {
            if ((axorb & i) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
