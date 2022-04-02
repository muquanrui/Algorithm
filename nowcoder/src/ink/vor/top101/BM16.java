package ink.vor.top101;

/**
 * @author muquanrui
 * @date 02/04/2022 17:13
 */
public class BM16 {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(111);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        int preVal = pre.val;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == preVal || cur.val == cur.next.val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            preVal = cur.val;
            cur = cur.next;
        }
        if (cur.val == preVal) {
            pre.next = null;
        }
        return dummyHead.next;
    }
}
