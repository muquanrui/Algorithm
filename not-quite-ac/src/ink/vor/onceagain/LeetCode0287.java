package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/25 22:24
 */

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/
 * 数组，快慢指针
 */
public class LeetCode0287 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
