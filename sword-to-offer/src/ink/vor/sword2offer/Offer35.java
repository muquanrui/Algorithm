package ink.vor.sword2offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/4/23 17:52
 */
public class Offer35 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        Node oldCur= head;
        Node newCur = newHead;
        Map<Node, Node> map = new HashMap<>();
        map.put(head, newHead);
        while (oldCur != null) {
            if (oldCur.next != null && map.get(oldCur.next) == null) {
                newCur.next = new Node(oldCur.next.val);
                map.put(oldCur.next, newCur.next);
            } else {
                newCur.next = map.get(oldCur.next);
            }

            if (oldCur.random != null && map.get(oldCur.random) == null) {
                newCur.random = new Node(oldCur.random.val);
                map.put(oldCur.random, newCur.random);
            } else {
                newCur.random = map.get(oldCur.random);
            }
            newCur = newCur.next;
            oldCur = oldCur.next;
        }
        return newHead;
    }
}

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