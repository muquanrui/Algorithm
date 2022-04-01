package ink.vor.top101;

/**
 * @author muquanrui
 * @date 01/04/2022 23:19
 */
public class BM11 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode newHead1 = reverseList(head1);
        ListNode newHead2 = reverseList(head2);
        int carry = 0;
        ListNode cur1 = newHead1;
        ListNode cur2 = newHead2;
        ListNode dummyHead = new ListNode(0);
        ListNode resNode = dummyHead;
        while (cur1 != null || cur2 != null) {
            int val1 = cur1 == null ? 0 : cur1.val;
            int val2 = cur2 == null ? 0 : cur2.val;
            int res = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            resNode.next = new ListNode(res);
            resNode = resNode.next;
            cur1 = cur1 == null ? cur1 : cur1.next;
            cur2 = cur2 == null ? cur2 : cur2.next;
        }
        if (carry > 0) {
            resNode.next = new ListNode(carry);
        }
        resNode = dummyHead.next;
        dummyHead.next = null;
        return reverseList(resNode);
    }

    private ListNode reverseList (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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
