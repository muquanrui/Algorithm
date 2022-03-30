package ink.vor.top101;

/**
 * @author muquanrui
 * @date 30/03/2022 22:10
 */
public class BM2 {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode preStart = dummyHead;
        int i = 1;
        while (i < m) {
            preStart = preStart.next;
            i++;
        }
        ListNode pre = null;
        ListNode cur = preStart.next;
        ListNode start = cur;
        while (i <= n) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            i++;
        }
        preStart.next = pre;
        start.next = cur;
        return dummyHead.next;
    }
}
