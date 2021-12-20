package ink.vor.top100liked;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author muquanrui
 * @date 20/12/2021 22:26
 */
public class LeetCode0160 {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode temp = headA;
//        Set<ListNode> set = new HashSet<>();
//        while (temp != null) {
//            set.add(temp);
//            temp = temp.next;
//        }
//        temp = headB;
//        while (temp != null) {
//            if (set.contains(temp)) {
//                return temp;
//            }
//            temp = temp.next;
//        }
//        return null;
//    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
         return null;
       }
        ListNode tailA = headA;
        while (tailA.next != null) {
            tailA = tailA.next;
        }
        tailA.next = headB;
        ListNode slow = headA.next;
        ListNode fast = headA.next.next;
        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow != fast) {
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
