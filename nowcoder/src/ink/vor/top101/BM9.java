package ink.vor.top101;

/**
 * @author muquanrui
 * @date 01/04/2022 22:42
 */
public class BM9 {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        if (head == null) {
            return null;
        }
        // write code here
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = dummyHead;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
