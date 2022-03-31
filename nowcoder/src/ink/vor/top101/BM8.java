package ink.vor.top101;

/**
 * @author muquanrui
 * @date 31/03/2022 20:37
 */
public class BM8 {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode fast = pHead;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        ListNode slow = pHead;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
