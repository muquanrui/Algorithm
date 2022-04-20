package ink.vor.top101;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/4/20 07:53
 */
public class BM100 {
}

class Solution {
    LRUNode head;
    LRUNode tail;
    Map<Integer, LRUNode> map;
    int capacity;

    public Solution(int capacity) {
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        LRUNode cur = map.get(key);
        if (cur == null) {
            return -1;
        }
        moveToHead(cur);
        return cur.val;
    }

    public void set(int key, int value) {
        LRUNode cur = map.get(key);
        if (cur != null) {
            moveToHead(cur);
            cur.val = value;
            return;
        }
        LRUNode newNode = new LRUNode();
        newNode.key = key;
        newNode.val = value;
        addNode(newNode);
        if (map.size() == capacity) {
            LRUNode oldNode = tail.pre;
            oldNode.pre.next = tail;
            tail.pre = oldNode.pre;
            map.remove(oldNode.key);
        }
        map.put(key, newNode);
    }

    public void moveToHead(LRUNode cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        addNode(cur);
    }

    public void addNode(LRUNode newNode) {
        newNode.next = head.next;
        head.next.pre = newNode;
        newNode.pre = head;
        head.next = newNode;
    }
}

class LRUNode {
    int key = -1;
    int val = -1;
    LRUNode pre;
    LRUNode next;
}