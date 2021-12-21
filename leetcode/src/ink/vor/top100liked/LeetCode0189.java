package ink.vor.top100liked;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 21/12/2021 17:26
 */
public class LeetCode0189 {
//    public void rotate(int[] nums, int k) {
//        int[] copyNums = Arrays.copyOf(nums, nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            if (i < k % nums.length) {
//                nums[i] = copyNums[nums.length - k % nums.length + i];
//            } else {
//                nums[i] = copyNums[i - k % nums.length];
//            }
//        }
//    }

//    public void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        if (k == 0) {
//            return;
//        }
//        int a = nums.length;
//        int b = k;
//        while (a % b != 0) {
//            int temp = a % b;
//            a = b;
//            b = temp;
//        }
//        int gcd = b;
//        for (int i = 0; i < gcd; i++) {
//            int index = i;
//            int last = nums[index];
//            for (int j = 0; j < nums.length / gcd; j++) {
//                index = (index + k) % nums.length;
//                int temp = nums[index];
//                nums[index] = last;
//                last = temp;
//            }
//        }
//    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int start = 0;
        int index = start;
        int last = nums[index];
        for (int i = 0; i < nums.length; i++) {
            index = (index + k) % nums.length;
            int temp = nums[index];
            nums[index] = last;
            last = temp;
            if (index == start) {
                start++;
                index = start;
                last = nums[index];
            }
        }
    }

}
