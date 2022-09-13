package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/20 12:59
 */

/**
 * https://leetcode.cn/problems/palindrome-linked-list/
 * 链表，快慢指针
 */
public class LeetCode0234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (fast != null) {
            slow = cur.next;
        }
        fast = pre;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
