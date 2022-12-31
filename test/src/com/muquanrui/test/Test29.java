package com.muquanrui.test;

/**
 * @author muquanrui
 * @date 2022/10/16 20:01
 */

public class Test29 {
    class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode xorList (ListNode a, ListNode b) {
        // write code here
        ListNode curA = a;
        ListNode curB = b;
        if (curA == null) {
            return reverseList(curB);
        }
        if (curB == null) {
            return curA;
        }
        curA = reverseList(curA);
        ListNode dummyHead = new ListNode(0);
        ListNode curC = dummyHead;
        while (curA != null && curB != null) {
            curA.val = curA.val ^ curB.val;
            curC.next = curA;
            curA = curA.next;
            curB = curB.next;
            curC = curC.next;
        }
        if (curA == null) {
            curC.next = curB;
        } else {
            curC.next = curA;
        }
        dummyHead = dummyHead.next;
        dummyHead = reverseList(dummyHead);
        while (dummyHead != null && dummyHead.val == 0) {
            dummyHead = dummyHead.next;
        }
        return dummyHead;
    }

    private ListNode reverseList(ListNode head) {
        ListNode curA = head;
        ListNode pre = null;
        ListNode next;
        while (curA != null) {
            next = curA.next;
            curA.next = pre;
            pre = curA;
            curA = next;
        }
        return pre;
    }
}

