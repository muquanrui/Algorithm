package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/16 20:34
 */
public class BM72 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int preSum = array[0];
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            preSum = Math.max(preSum + array[i], array[i]);
            res = Math.max(res, preSum);
        }
        return res;
    }
}
