package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/22 17:43
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        ListNode slow = dummyHead;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
