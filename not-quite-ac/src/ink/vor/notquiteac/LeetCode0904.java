package ink.vor.notquiteac;

import java.util.HashMap;

/**
 * @author muquanrui
 * @date 2022/7/2 18:04
 */
public class LeetCode0904 {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int res = 1;
        int bucketNo1 = fruits[left];
        int lastIndexNo1 = left;
        int bucketNo2 = -1;
        int lastIndexNo2 = -1;
        int tempCount = 1;
        for (int right = 1; right < fruits.length; right++) {
            if (fruits[right] == bucketNo1) {
                tempCount++;
                lastIndexNo1 = right;
            } else if (fruits[right] == bucketNo2 || bucketNo2 == -1) {
                tempCount++;
                bucketNo2 = fruits[right];
                lastIndexNo2 = right;
            } else {
                if (fruits[right - 1] == bucketNo1) {
                    left = lastIndexNo2 + 1;
                    bucketNo2 = fruits[right];
                    lastIndexNo2 = right;
                } else {
                    left = lastIndexNo1 + 1;
                    bucketNo1 = fruits[right];
                    lastIndexNo1 = right;
                }
                tempCount = right - left + 1;
            }
            res = Math.max(res, tempCount);
        }
        return res;
    }
}
