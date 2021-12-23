package ink.vor.top100liked;

import java.util.List;
import java.util.Stack;

/**
 * @author muquanrui
 * @date 23/12/2021 22:41
 */
public class LeetCode0206 {
//    public ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode temp = head;
//        Stack<ListNode> stack = new Stack<>();
//        while (temp != null) {
//            stack.push(temp);
//            temp = temp.next;
//        }
//        ListNode newHead = stack.pop();
//        temp = newHead;
//        while (!stack.isEmpty()) {
//            temp.next = stack.pop();
//            temp = temp.next;
//        }
//        temp.next = null;
//        return newHead;
//    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode next = pre.next;
        pre.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }
        return pre;
    }
}
