package ink.vor.top100liked;

import java.util.HashSet;

/**
 * @author muquanrui
 * @date 17/12/2021 10:33
 */
public class LeetCode0141 {
//    public boolean hasCycle(ListNode head) {
//        HashSet<ListNode> set = new HashSet<>();
//        ListNode temp = head;
//        while (temp != null) {
//            if (set.contains(temp)) {
//                return true;
//            }
//            set.add(temp);
//            temp = temp.next;
//        }
//        return false;
//    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
