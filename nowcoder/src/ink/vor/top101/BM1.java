package ink.vor.top101;

/**
 * @author muquanrui
 * @date 30/03/2022 21:50
 */
public class BM1 {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}