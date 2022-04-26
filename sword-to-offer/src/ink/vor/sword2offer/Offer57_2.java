package ink.vor.sword2offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/4/26 14:29
 */
public class Offer57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int left = 1;
        int right = 2;
        while (left < right) {
            int sum = ((right - left + 1) * (left + right)) / 2;
            if (sum < target) {
                right++;
            } else if (sum > target){
                left++;
            } else {
                int[] res = new int[right - left + 1];
                for (int i = 0; i < res.length; i++) {
                    res[i] = left + i;
                }
                list.add(res);
                left++;
            }
        }
        int[][] resList = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            resList[i] = list.get(i);
        }
        return resList;
    }
}
