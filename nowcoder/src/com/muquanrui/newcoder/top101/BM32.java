package com.muquanrui.newcoder.top101;

/**
 * @author muquanrui
 * @date 06/04/2022 03:41
 */
public class BM32 {
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
