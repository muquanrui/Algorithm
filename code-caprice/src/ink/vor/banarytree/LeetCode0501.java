package ink.vor.banarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/6 11:39
 */
public class LeetCode0501 {
    int modeCount = 1;
    int count = 1;
    List<Integer> modeList = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] res = new int[modeList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = modeList.get(i);
        }
        return res;
    }
    TreeNode pre = null;
    private void inorder(TreeNode root) {
        if (root.left != null) {
            inorder(root.left);
        }
        if (pre != null && pre.val == root.val) {
            count++;
        } else {
            count = 1;
        }
        if (count == modeCount) {
            modeList.add(root.val);
        } else if (count > modeCount) {
            modeCount = count;
            modeList = new ArrayList<>();
            modeList.add(root.val);
        }
        pre = root;
        if (root.right != null) {
            inorder(root.right);
        }
    }
}
