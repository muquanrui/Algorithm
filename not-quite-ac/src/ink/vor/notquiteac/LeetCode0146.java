package ink.vor.notquiteac;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/6/13 13:59
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
        LRUNode cur = map.get(key);
        if (cur == null) {
            return -1;
        }
        deleteNode(cur);
        addHead(cur);
        return cur.value;
    }

    public void put(int key, int value) {
        LRUNode cur = map.get(key);
        if (cur == null) {
            if (map.size() == capacity) {
                map.remove(deleteTail().key);
            }
            cur = new LRUNode();
        } else {
            deleteNode(cur);
        }
        cur.key = key;
        cur.value = value;
        addHead(cur);
        map.put(key, cur);
    }

    private void addHead (LRUNode cur) {
        cur.pre = head;
        cur.next = head.next;
        head.next.pre = cur;
        head.next = cur;
    }

    private LRUNode deleteNode (LRUNode cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        return cur;
    }

    private LRUNode deleteTail() {
        LRUNode cur = tail.pre;
        return deleteNode(cur);
    }
}

class LRUNode {
    int key;
    int value;
    LRUNode pre;
    LRUNode next;
}