package ink.vor.notquiteac;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/7/20 20:48
 */
public class Offer57 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> resList = new ArrayList<>();
        int left = 1;
        int right = 2;
        while (left < right) {
            int sum = ((right - left + 1) * (left + right)) / 2;
            if (sum < target) {
                right++;
            } else if (sum > target){
                left++;
            } else {
                int[] arr = new int[right - left + 1];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = left + i;
                }
                resList.add(arr);
                left++;
            }
        }
        int[][] res = resList.toArray(new int[0][0]);
        return res;
    }
}
