package ink.vor.top101;

/**
 * @author muquanrui
 * @date 01/04/2022 23:19
 */
public class BM10 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode temp = pHead1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = pHead2;
        ListNode fast = pHead1;
        ListNode slow = pHead1;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            temp.next = null;
            return null;
        }
        slow = pHead1;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        temp.next = null;
        return slow;
    }
}
