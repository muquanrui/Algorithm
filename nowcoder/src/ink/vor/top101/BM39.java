package ink.vor.top101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 07/04/2022 01:30
 */
public class BM39 {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#.");
            return;
        }
        sb.append(String.valueOf(root.val));
        sb.append(".");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    TreeNode Deserialize(String str) {
        if (str.length() == 0) {
            return null;
        }
        String[] arr = str.split("\\.");
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(arr));
        return parse(nodes);
    }

    private TreeNode parse(LinkedList<String> nodes) {
        String str = nodes.removeFirst();
        if (str.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = parse(nodes);
        root.right = parse(nodes);
        return root;
    }
}
