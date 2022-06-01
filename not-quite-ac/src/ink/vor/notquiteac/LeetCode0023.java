package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/5/31 16:28
 */

// https://leetcode.cn/problems/merge-k-sorted-lists/
public class LeetCode0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int k = lists.length;
        while (k > 1) {
            int incr = (k + 1) / 2;
            for (int i = 0; i < incr && i + incr < k; i++) {
                lists[i] = mergeKLists(lists[i], lists[i + incr]);
            }
            k = incr;
        }
        return lists[0];
    }

    public ListNode mergeKLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 == null) {
            cur.next = cur2;
        } else {
            cur.next = cur1;
        }
        return dummyHead.next;
    }
}
