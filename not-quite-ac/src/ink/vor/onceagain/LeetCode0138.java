package ink.vor.onceagain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/6/13 13:45
 */

/**
 * https://leetcode.cn/problems/copy-list-with-random-pointer/
 * 链表，HashMap
 */
public class LeetCode0138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node oldCur = head;
        Node newHead = new Node(head.val);
        Node newCur = newHead;
        Map<Node, Node> map = new HashMap<>();
        map.put(head, newHead);
        while (oldCur != null) {
            if (oldCur.next == null || map.containsKey(oldCur.next)) {
                newCur.next = map.get(oldCur.next);
            } else {
                newCur.next = new Node(oldCur.next.val);
                map.put(oldCur.next, newCur.next);
            }
            if (oldCur.random == null || map.containsKey(oldCur.random)) {
                newCur.random = map.get(oldCur.random);
            } else {
                newCur.random = new Node(oldCur.random.val);
                map.put(oldCur.random, newCur.random);
            }
            oldCur = oldCur.next;
            newCur = newCur.next;
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
