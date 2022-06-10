package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/10 14:25
 */
// https://leetcode.cn/problems/reverse-linked-list-ii/
public class LeetCode0092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        int index = 1;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (index < left) {
            pre = cur;
            cur = cur.next;
            index++;
        }
        ListNode start = pre;
        ListNode next;
        while (index <= right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            index++;
        }
        start.next.next = cur;
        start.next = pre;
        return dummyHead.next;
    }
}
