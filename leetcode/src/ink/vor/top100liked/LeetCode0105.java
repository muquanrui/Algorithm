package ink.vor.top100liked;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 14/12/2021 14:14
 */
public class LeetCode0105 {
    public static void main(String[] args) {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return recursiveBuild(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public static TreeNode recursiveBuild(int[] preorder, int[] inorder, int startPre, int endPre, int startIn, int endIn) {
        if (startPre >= endPre || startIn >= endIn) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[startPre]);

        for (int i = startIn; i < endIn; i++) {
            if (inorder[i] == root.val) {
                root.left = recursiveBuild(preorder, inorder, startPre + 1, startPre + i - startIn + 1, startIn, i);
                root.right = recursiveBuild(preorder, inorder, startPre + i - startIn + 1, endPre, i + 1, endIn);
                break;
            }
        }

        return root;
    }

//    public static TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder.length == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode();
//        recursiveBuild(preorder, inorder, root, 0, 0, preorder.length);
//        return root;
//    }
//
//    public static void recursiveBuild(int[] preorder, int[] inorder, TreeNode root, int rootPre, int leftBound, int rightBound) {
//        root.val = preorder[rootPre];
//        int rootIn = -1;
//        for (int i = leftBound; i < rightBound; i++) {
//            if (inorder[i] == root.val) {
//                rootIn = i;
//                break;
//            }
//        }
//
//        if (leftBound < rootIn) {
//            root.left = new TreeNode();
//            recursiveBuild(preorder, inorder, root.left, rootPre + 1, leftBound, rootIn);
//        }
//        if (rootIn + 1 < rightBound) {
//            root.right = new TreeNode();
//            recursiveBuild(preorder, inorder, root.right, rootPre + rootIn - leftBound + 1, rootIn + 1, rightBound);
//        }
//    }
}
