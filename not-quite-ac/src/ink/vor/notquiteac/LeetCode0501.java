package ink.vor.notquiteac;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/29 15:59
 */
public class LeetCode0501 {
    List<Integer> list = new ArrayList<>();
    int maxCount = 1;
    int count = 1;
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    int pre = Integer.MAX_VALUE;
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (root.val == pre) {
            count++;
        } else {
            count = 1;
        }
        if (count == maxCount) {
            list.add(root.val);
        }
        if (count > maxCount) {
            maxCount = count;
            list = new ArrayList<>();
            list.add(root.val);
        }
        pre = root.val;
        inorder(root.right);
    }
}
