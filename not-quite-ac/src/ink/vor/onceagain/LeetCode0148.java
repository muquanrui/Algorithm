package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/13 16:22
 */

/**
 * https://leetcode.cn/problems/sort-list/
 * 链表，分治算法
 */
public class LeetCode0148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) {
            cur.next = cur1;
        } else {
            cur.next = cur2;
        }
        return dummyHead.next;
    }
}
