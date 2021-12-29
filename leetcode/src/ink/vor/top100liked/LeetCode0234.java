package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 29/12/2021 16:46
 */
public class LeetCode0234 {
    //    public boolean isPalindrome(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        ListNode temp = head;
//        while (temp != null) {
//            list.add(temp.val);
//            temp = temp.next;
//        }
//        int left = list.size() / 2 - 1;
//        int right = (list.size() + 1) / 2;
//
//        while (left >= 0 && right <= list.size() - 1) {
//            if (list.get(left) != list.get(right)) {
//                return false;
//            }
//            left--;
//            right++;
//        }
//        return true;
//    }
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        while (next != null) {
            ListNode pre = slow;
            slow = next;
            next = slow.next;
            slow.next = pre;
        }

        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}
