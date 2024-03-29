package com.muquanrui.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author muquanrui
 * @date 23/02/2022 20:17
 */
public class LeetCode0513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode leftMost = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                    leftMost = cur.left;
                }
            }
        }
        return leftMost.val;
    }
}
