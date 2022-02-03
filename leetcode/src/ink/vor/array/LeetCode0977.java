package ink.vor.array;

/**
 * @author muquanrui
 * @date 03/02/2022 12:55
 */
public class LeetCode0977 {
    public int[] sortedSquares(int[] nums) {
        int[] newNums = new int[nums.length];
        int index = newNums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int numLeft = Math.abs(nums[left]);
            int numRight = Math.abs(nums[right]);
            if (numLeft >= numRight) {
                newNums[index] = numLeft * numLeft;
                left++;
            } else {
                newNums[index] = numRight * numRight;
                right--;
            }
            index--;
        }
        return newNums;
    }
}
