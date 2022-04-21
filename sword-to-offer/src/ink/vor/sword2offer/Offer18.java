package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/21 14:55
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
