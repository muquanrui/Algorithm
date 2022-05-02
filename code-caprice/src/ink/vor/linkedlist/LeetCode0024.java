package ink.vor.linkedlist;

/**
 * @author muquanrui
 * @date 2022/5/1 19:03
 */
public class LeetCode0024 {
    // public ListNode swapPairs(ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }
    //     ListNode dummyHead = new ListNode();
    //     dummyHead.next = head;
    //     ListNode pre = dummyHead;
    //     ListNode cur = pre.next;
    //     ListNode next;
    //     while (cur != null && cur.next != null) {
    //         next = cur.next;
    //         pre.next = next;
    //         cur.next = next.next;
    //         next.next = cur;
    //         pre = cur;
    //         cur = cur.next;
    //     }
    //     return dummyHead.next;
    // }
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        if (next == null) {
            return cur;
        }
        ListNode tmp = next.next;
        next.next = head;
        cur.next = swapPairs(tmp);
        return next;
    }
}
