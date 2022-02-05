package ink.vor.linkedlist;

/**
 * @author muquanrui
 * @date 05/02/2022 20:21
 */
public class LeetCode0707 {

}

class MyLinkedList {
    MyNode head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        MyNode temp = head;
        while (temp != null) {
            if (--index == -1) {
                return temp.val;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        MyNode newNode = new MyNode(val);
        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        MyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new MyNode(val);
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (head == null) {
            return;
        }
        MyNode newNode = new MyNode(val);
        MyNode pre = head;
        while (pre.next != null) {
            if (--index == 0) {
                newNode.next = pre.next;
                pre.next = newNode;
                return;
            }
            pre = pre.next;
        }
        if (--index == 0) {
            addAtTail(val);
        }
    }

    public void deleteAtIndex(int index) {
        MyNode dummyNode = new MyNode();
        dummyNode.next = head;
        MyNode temp = dummyNode;
        while (temp.next != null) {
            if (--index == -1) {
                temp.next = temp.next.next;
                head = dummyNode.next;
                return;
            }
            temp = temp.next;
        }
    }
}

class MyNode {
    int val;
    MyNode next;
    public MyNode() {
    }
    public MyNode(int val) {
        this.val = val;
    }
    public MyNode(int val, MyNode next) {
        this.val = val;
        this.next = next;
    }
}
