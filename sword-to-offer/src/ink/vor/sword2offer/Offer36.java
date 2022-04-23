package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/23 17:53
 */
public class Offer36 {
    class Solution {
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            Node tail = buildList(root);
            head.left = tail;
            tail.right = head;
            return head;
        }
        private Node pre = null;
        private Node head = null;
        private Node buildList(Node root) {
            if (root.left != null) {
                buildList(root.left);
            }
            if (pre != null) {
                pre.right = root;
                root.left = pre;
            }
            if (head == null) {
                head = root;
            }
            pre = root;
            if (root.right != null) {
                return buildList(root.right);
            }
            return root;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}


