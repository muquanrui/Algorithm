package ink.vor.linkedlist;

import java.util.List;

/**
 * @author muquanrui
 * @date 06/02/2022 22:32
 */
public class LeetCode0206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        if (cur == null || cur.next == null) {
            return cur;
        }
        ListNode pre = null;
        ListNode next = cur.next;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;
        return cur;
    }
}
