package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 25/02/2022 21:14
 */
public class LeetCode0654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        int maxI = getMaxNumIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[maxI]);
        if (maxI > left) {
            root.left = constructMaximumBinaryTree(nums, left, maxI - 1);
        }
        if (maxI < right) {
            root.right = constructMaximumBinaryTree(nums, maxI + 1, right);
        }
        return root;
    }

    private int getMaxNumIndex(int[] nums, int left, int right) {
        int maxI = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxI]) {
                maxI = i;
            }
        }
        return maxI;
    }
}
