package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 30/11/2021 17:30
 */
public class LeetCode0021 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,4};
        int[] arr2 = new int[]{1,3,4};
        ListNode l1 = LeetCode0002.convertArrayToList(arr1);
        ListNode l2 = LeetCode0002.convertArrayToList(arr2);
        ListNode nodeRes = mergeTwoLists(l1, l2);
        while (nodeRes != null) {
            System.out.print(nodeRes.val + " -> ");
            nodeRes = nodeRes.next;
        }
    }

    public static final int INF = 101;
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode newHead = new ListNode();
        ListNode tempNew = newHead;
        while (temp1 != null || temp2 != null) {
            int val1 = temp1 != null ? temp1.val : INF;
            int val2 = temp2 != null ? temp2.val : INF;

            if (val1 < val2) {
                tempNew.next = temp1;
                tempNew = tempNew.next;
                temp1 = temp1.next;
            } else {
                tempNew.next = temp2;
                tempNew = tempNew.next;
                temp2 = temp2.next;
            }
        }
        return newHead.next;
    }
}
