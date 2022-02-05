package ink.vor.linkedlist;

/**
 * @author muquanrui
 * @date 05/02/2022 19:55
 */
public class LeetCode0203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
