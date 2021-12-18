package ink.vor.top100liked;

import java.util.*;

/**
 * @author muquanrui
 * @date 18/12/2021 16:48
 */
public class LeetCode0146 {

}

class LRUCache {

    private Map<Integer, DoubleNode> map;
    private int capacity;
    private DoubleNode head;
    private DoubleNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DoubleNode();
        tail = new DoubleNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            DoubleNode node = map.get(key);
            removeNode(node);
            addNode(node);
            return map.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            DoubleNode node = map.get(key);
            removeNode(node);
            addNode(node);
            node.value = value;
        } else {
            if (map.size() == capacity) {
                map.remove(tail.pre.key);
                removeLastNode();
            }
            DoubleNode node = new DoubleNode(key, value);
            map.put(key, node);
            addNode(node);
        }
    }

    public void removeNode(DoubleNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void removeLastNode() {
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;
    }

    public void addNode(DoubleNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
}

class DoubleNode {
    int key;
    int value;
    DoubleNode pre;
    DoubleNode next;

    public DoubleNode() {
    }

    public DoubleNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}