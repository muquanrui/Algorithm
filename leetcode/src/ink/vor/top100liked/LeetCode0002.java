package ink.vor.top100liked;

import org.w3c.dom.Node;

/**
 * @author muquanrui
 * @date 25/11/2021 10:27
 */
public class LeetCode0002 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{9,9,9,9,9,9,9};
        int[] arr2 = new int[]{9,9,9,9};
        ListNode l1 = convertArrayToList(arr1);
        ListNode l2 = convertArrayToList(arr2);
        ListNode nodeRes = addTwoNumbers(l1, l2);
        while (nodeRes != null) {
            System.out.print(nodeRes.val + " -> ");
            nodeRes = nodeRes.next;
        }
    }

    public static ListNode convertArrayToList(int[] arr) {
        ListNode startRes = new ListNode(arr[0]);
        ListNode tempRes = startRes;
        for (int i = 1; i < arr.length; i++) {
            tempRes.next = new ListNode(arr[i]);
            tempRes = tempRes.next;
        }
        return startRes;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode startRes = new ListNode();
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode tempRes = startRes;

        int carry = 0;
        while (temp1 != null || temp2 !=null) {
            int val1 = temp1 != null ? temp1.val : 0;
            int val2 = temp2 != null ? temp2.val : 0;
            tempRes.next = new ListNode((val1 + val2 + carry) % 10);
            tempRes = tempRes.next;
            carry = (val1 + val2 + carry) / 10;
            temp1 = temp1 != null ? temp1.next : null;
            temp2 = temp2 != null ? temp2.next : null;
        }

        if (carry > 0) {
            tempRes.next = new ListNode(carry);
        }
        return startRes.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}