package com.muquanrui.notquiteac.onceagain;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/7/8 15:48
 */

/**
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
 * 完全二叉树
 */
public class LeetCode0958 {
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        TreeNode cur;
        boolean isNull = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur != null) {
                    if (isNull) {
                        return false;
                    }
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else {
                    isNull = true;
                }
            }
        }
        return true;
    }
}
