package ink.vor.top101;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author muquanrui
 * @date 2022/4/20 11:27
 */
public class BM101 {
}

class LFUCache {
    LFUNode head;
    LFUNode tail;
    Map<Integer, LFUNode> nodeMap;
    TreeMap<Integer, LFUNode> freqMap;
    int capacity;

    public LFUCache(int capacity) {
        head = new LFUNode();
        tail = new LFUNode();
        head.next = tail;
        tail.pre = head;
        nodeMap = new HashMap<>();
        freqMap = new TreeMap<>(((f1, f2) -> Integer.compare(f2, f1)));
        freqMap.put(Integer.MAX_VALUE, head);
        freqMap.put(0, tail);
        this.capacity = capacity;
    }

    public int get(int key) {
        LFUNode node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }
        useNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        LFUNode node = nodeMap.get(key);
        if (node != null) {
            useNode(node);
            node.val = value;
            return;
        }
        LFUNode newNode = new LFUNode();
        newNode.key = key;
        newNode.val = value;
        newNode.freq = 1;
        if (nodeMap.size() == capacity) {
            removeLFUNode();
        }
        addNode(newNode);
    }

    public void useNode(LFUNode node) {
        int freq = node.freq;
        removeNode(node);
        node.freq = ++freq;
        addNode(node);
    }

    public void removeLFUNode() {
        LFUNode node = tail.pre;
        removeNode(node);
    }

    public void removeNode(LFUNode node) {
        LFUNode oldFreqHead = freqMap.get(node.freq);
        if (node == oldFreqHead) {
            if (node.next.freq == node.freq) {
                freqMap.put(node.freq, node.next);
            } else {
                freqMap.remove(node.freq);
            }
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        nodeMap.remove(node.key);
    }

    public void addNode(LFUNode node) {
        LFUNode newFreqHead = freqMap.get(node.freq);
        freqMap.put(node.freq, node);
        if (newFreqHead == null) {
            int ctrl = 0;
            for (Map.Entry<Integer, LFUNode> entry: freqMap.entrySet()) {
                if (ctrl == 1) {
                    newFreqHead = entry.getValue();
                    break;
                }
                if (entry.getValue() == node) {
                    ctrl = 1;
                }
            }
        }
        node.pre = newFreqHead.pre;
        node.next = newFreqHead;
        newFreqHead.pre.next = node;
        newFreqHead.pre = node;
        nodeMap.put(node.key, node);
    }
}

class LFUNode {
    int key;
    int val;
    int freq;
    LFUNode pre;
    LFUNode next;
}