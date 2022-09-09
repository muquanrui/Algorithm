package ink.vor.onceagain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/6/13 13:59
 */

/**
 * https://leetcode.cn/problems/lru-cache/
 * 双向链表，HashMap
 */
public class LeetCode0146 {
}

class LRUCache {
    Map<Integer, LRUNode> map;
    LRUNode head;
    LRUNode tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        LRUNode node = map.get(key);
        moveFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LRUNode node = map.get(key);
            node.val = value;
            moveFront(node);
            return;
        }
        if (map.size() == capacity) {
            map.remove(deleteTail().key);
        }
        LRUNode node = new LRUNode(key, value);
        addFront(node);
        map.put(key, node);
    }

    private void addFront(LRUNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private LRUNode deleteTail() {
        LRUNode node = tail.pre;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }

    private void moveFront(LRUNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addFront(node);
    }
}

class LRUNode {
    int key;
    int val;
    LRUNode pre;
    LRUNode next;

    public LRUNode() {
    }

    public LRUNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}