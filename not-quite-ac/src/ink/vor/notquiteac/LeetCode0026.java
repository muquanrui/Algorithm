package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/5/31 20:45
 */

// https://leetcode.cn/problems/reverse-nodes-in-k-group/
public class LeetCode0026 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextHead = head;
        for (int i = 0; i < k; i++) {
            if (nextHead == null) {
                return head;
            }
            nextHead = nextHead.next;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(nextHead, k);
        return pre;
    }
}
