package ink.vor.test.oj;

import com.sun.tools.javac.Main;

import javax.swing.tree.TreeNode;
import java.util.Scanner;

/**
 * @author muquanrui
 * @date 2022/10/22 16:02
 */

public class Test33 {
    int i = 1;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        i++;
        if (i == k) {
            res = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        String pStr = scanner.nextLine();
        String arrayStr = inputStr.substring(1, inputStr.lastIndexOf("]"));
        String[] arrayStrArray = arrayStr.split(",");
        Integer[] array = new Integer[arrayStrArray.length];
        for (int i = 0; i < arrayStrArray.length; i++) {
            if ("null".equals(arrayStrArray[i])) {
                continue;
            }
            array[i] = Integer.valueOf(arrayStrArray[i]);
        }

        TreeNode root = createTree(0, array);
        System.out.println(new Test33().kthSmallest(root, Integer.parseInt(pStr)));
    }

    static TreeNode createTree(int rootIndex, Integer[] values) {
        if (rootIndex >= values.length) {
            return null;
        }
        if (values[rootIndex] == null) {
            return null;
        }
        TreeNode rootNode = new TreeNode();
        rootNode.val = values[rootIndex];
        rootNode.left = createTree(2 * rootIndex + 1, values);
        rootNode.right = createTree(2 * rootIndex + 2, values);
        return rootNode;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
