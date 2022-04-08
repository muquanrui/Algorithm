package ink.vor.top101;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 08/04/2022 02:18
 */
public class BM41 {
    public int[] solve (int[] xianxu, int[] zhongxu) {
        TreeNode root = reConstructBinaryTree(xianxu, zhongxu);
        if (root == null) {
            return new int[]{};
        }
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur = null;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.addLast(cur.val);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.removeFirst();
        }
        return res;
    }

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
