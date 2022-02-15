package ink.vor.doublepointer;

import java.util.List;

/**
 * @author muquanrui
 * @date 15/02/2022 14:32
 */
public class LeetCode0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = dummyHead;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
