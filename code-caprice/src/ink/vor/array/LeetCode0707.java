package ink.vor.array;

/**
 * @author muquanrui
 * @date 2022/5/1 18:36
 */
public class LeetCode0707 {
}
class MyLinkedList {
    Node head;
    Node tail;

    public MyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        Node cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
            if (cur == tail) {
                return -1;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node();
        newNode.val = val;
        newNode.next = head.next;
        newNode.pre = head;
        head.next = newNode;
        newNode.next.pre = newNode;
    }

    public void addAtTail(int val) {
        Node newNode = new Node();
        newNode.val = val;
        newNode.next = tail;
        newNode.pre = tail.pre;
        tail.pre = newNode;
        newNode.pre.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
            return;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
            if (cur == tail) {
                return;
            }
        }
        Node newNode = new Node();
        newNode.val = val;
        newNode.next = cur.next;
        newNode.pre = cur;
        cur.next = newNode;
        newNode.next.pre = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        Node cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
            if (cur == tail) {
                return;
            }
        }
        cur.next.pre = cur.pre;
        cur.pre.next = cur.next;
    }
}

class Node {
    int val;
    Node pre;
    Node next;
}
