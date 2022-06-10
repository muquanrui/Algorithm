package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/10 15:41
 */
public class LeetCode0082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
            if (cur.val == next.val) {
                next = next.next;
                pre.next = next;
                continue;
            }
            if (pre.next == cur) {
                pre = cur;
            }
            cur = next;
            next = cur.next;
        }
        return dummyHead.next;
    }
}
