package ink.vor.top101;

/**
 * @author muquanrui
 * @date 30/03/2022 22:28
 */
public class BM3 {
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode oldHead = head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        head = reverse(oldHead, end);
        oldHead.next = reverseKGroup(end, k);
        return head;
    }
    private ListNode reverse (ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode cur = start;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
