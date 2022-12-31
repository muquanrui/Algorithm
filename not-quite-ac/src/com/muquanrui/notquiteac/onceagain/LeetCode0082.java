package com.muquanrui.notquiteac.onceagain;


/**
 * @author muquanrui
 * @date 2022/6/10 15:41
 */

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 * 链表
 */
public class LeetCode0082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 一般涉及到删除的操作都需要dummyHead
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        // 前一个节点
        ListNode pre = dummyHead;
        // 当前节点
        ListNode cur = head;
        // 下一个节点
        ListNode next;
        while (cur != null) {
            next = cur.next;
            // 可能有连续的相同值，一直移动next，并更新pre的next达到删除的效果
            while (next != null && cur.val == next.val) {
                next = next.next;
                pre.next = next;
            }
            // 如果之前没有删除节点，才移动pre，如果删除了节点，就不移动pre
            pre = next == cur.next ? cur : pre;
            cur = next;
        }
        return dummyHead.next;
    }
}
