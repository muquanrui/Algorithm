package ink.vor.top100liked;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author muquanrui
 * @date 15/12/2021 11:30
 */
public class LeetCode0128 {

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int maxSequence = 1;
        int[] isVisited = new int[nums.length];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int sequence = 1;
            if (isVisited[entry.getValue()] == 0) {
                isVisited[entry.getValue()] = 1;
                int temp = entry.getKey() - 1;
                while (map.get(temp) != null) {
                    sequence++;
                    isVisited[map.get(temp)] = 1;
                    temp--;
                }
                temp = entry.getKey() + 1;
                while (map.get(temp) != null) {
                    sequence++;
                    isVisited[map.get(temp)] = 1;
                    temp++;
                }
                maxSequence = Math.max(maxSequence, sequence);
            }
        }
        return maxSequence;
    }
}
