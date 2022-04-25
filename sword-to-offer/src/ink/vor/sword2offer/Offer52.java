package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/25 16:06
 */
public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tailA = headA;
        while (tailA.next != null) {
            tailA = tailA.next;
        }
        tailA.next = headB;
        ListNode fast = headA;
        ListNode slow = headA;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            tailA.next = null;
            return null;
        }
        slow = headA;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        tailA.next = null;
        return slow;
    }
}
