package ink.vor.linkedlist;

/**
 * @author muquanrui
 * @date 06/02/2022 22:42
 */
public class LeetCode0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = pre.next;
        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            pre = cur;
            cur = pre.next;
        }
        return dummyHead.next;
    }
}
