package ink.vor.top100liked;

import java.util.List;

/**
 * @author muquanrui
 * @date 30/11/2021 16:45
 */
public class LeetCode0019 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1};
        ListNode head = LeetCode0002.convertArrayToList(arr1);
        ListNode nodeRes = removeNthFromEnd(head, 1);
        while (nodeRes != null) {
            System.out.print(nodeRes.val + " -> ");
            nodeRes = nodeRes.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int removeIndex = 1;
        temp = head;
        while (removeIndex < count - n) {
            removeIndex++;
            temp = temp.next;
        }
        if (count - n == 0) {
            head = head.next;
        } else {
            temp.next = temp.next.next;
        }
        return head;
    }
}