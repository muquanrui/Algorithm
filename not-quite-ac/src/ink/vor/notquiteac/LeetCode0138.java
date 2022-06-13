package ink.vor.notquiteac;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/6/13 13:45
 */
public class LeetCode0138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node old = head;
        Node newHead = new Node(head.val);
        Node cur = newHead;
        Map<Node, Node> map = new HashMap<>();
        map.put(old, cur);
        map.put(null, null);
        while (old != null) {
            if (map.containsKey(old.next)) {
                cur.next = map.get(old.next);
            } else {
                cur.next = new Node(old.next.val);
                map.put(old.next, cur.next);
            }
            if (map.containsKey(old.random)) {
                cur.random = map.get(old.random);
            } else {
                cur.random = new Node(old.random.val);
                map.put(old.random, cur.random);
            }
            cur = cur.next;
            old = old.next;
        }
        return newHead;
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
