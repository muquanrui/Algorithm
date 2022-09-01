package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/5/31 20:45
 */

import java.util.List;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * 链表，递归
 */
public class LeetCode0026 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        // 判断当前链表是否还剩余>=k的节点个数
        ListNode nextHead = head;
        for (int i = 0; i < k; i++) {
            if (nextHead == null) {
                return head;
            }
            nextHead = nextHead.next;
        }
        // 反转当前链表
        while (cur != nextHead) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 反转后的尾部指向下一段链表反转后的头部
        head.next = reverseKGroup(nextHead, k);
        return pre;
    }
}
