package ink.vor.test.oj;

/**
 * @author muquanrui
 * @date 2022/9/14 19:00
 */

public class Test02 {
    public Node Convert(Node pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        convertTree(pRootOfTree);
        return head;
    }

    Node pre = null;
    Node head = null;
    private void convertTree(Node root) {
        if (root.left != null) {
            convertTree(root.left);
        }
        if (pre == null) {
            head = root;
        } else {
            root.left = pre;
            pre.right = root;
        }
        pre = root;
        if (root.right != null) {
            convertTree(root.right);
        }
    }
}

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
