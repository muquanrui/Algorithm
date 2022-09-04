package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/10 14:25
 */
/**
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 * 链表
 */
public class LeetCode0092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        // 涉及到头节点变动的链表操作一般都用到dummyHead
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        // 找到链表的反转链表段，记录反转链表段的前一个节点
        ListNode start = dummyHead;
        for (int i = 1; i < left; i++) {
            start = start.next;
            i++;
        }
        // 反转链表
        ListNode pre = null;
        ListNode cur = start.next;
        ListNode next = null;
        for (int i = left; i <= right; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 将之前记录的前一个节点的next设置为反转后的头，之前的头的next设置为下一个节点
        start.next.next = next;
        start.next = pre;
        return dummyHead.next;
    }
}
