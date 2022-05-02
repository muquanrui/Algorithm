package ink.vor.linkedlist;

/**
 * @author muquanrui
 * @date 2022/5/1 18:57
 */
public class LeetCode0206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
