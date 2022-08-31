package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/5/31 16:28
 */

import java.util.List;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * 合并链表，归并思想
 */
public class LeetCode0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }
    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        // 链表数组为空，返回null
        if (left > right) {
            return null;
        }
        // 只有1个链表，返回该链表
        if (left == right) {
            return lists[left];
        }
        // 只有2个链表，返回合并结果
        if (left == right - 1) {
            return mergeTwoLists(lists[left], lists[right]);
        }
        // 有多于2个链表，递归划分，返回的链表进行合并
        int mid = left + (right - left) / 2;
        ListNode l1 = mergeKLists(lists, left, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }
    // 合并2条链表的方法
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
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
        if (cur1 != null) {
            cur.next = cur1;
        } else {
            cur.next = cur2;
        }
        return dummyHead.next;
    }
}
