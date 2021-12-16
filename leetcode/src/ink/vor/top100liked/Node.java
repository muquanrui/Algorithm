package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 16/12/2021 16:52
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
