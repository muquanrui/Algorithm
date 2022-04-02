package ink.vor.top101;

/**
 * @author muquanrui
 * @date 02/04/2022 17:07
 */
public class BM14 {
    public ListNode oddEvenList (ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode curOdd = oddHead;
        ListNode curEven = evenHead;
        ListNode cur = evenHead.next;
        while (cur != null) {
            curOdd.next = cur;
            curOdd = curOdd.next;
            curEven.next = cur.next;
            curEven = curEven.next;
            cur = cur.next != null ? cur.next.next : null;
        }
        curOdd.next = evenHead;
        return oddHead;
    }
}
