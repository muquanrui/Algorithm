package ink.vor.top101;

import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 08/04/2022 02:10
 */
public class BM40 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        return recursiveBuild(pre, vin, 0, pre.length - 1, 0);
    }

    private TreeNode recursiveBuild(int[] pre, int[] in, int left, int right, int curPre) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(pre[curPre]);
        int curIn = searchIn(in, left, right, pre[curPre]);
        root.left = recursiveBuild(pre, in, left, curIn - 1, curPre + 1);
        root.right = recursiveBuild(pre, in, curIn + 1, right, curPre + curIn - left + 1);
        return root;
    }

    private int searchIn(int[] in, int left, int right, int target) {
        for (int i = left; i <= right; i++) {
            if (in[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
