package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/5/29 10:29
 */

/**
 * https://leetcode.cn/problems/add-two-numbers/
 * 链表基础
 */
public class LeetCode0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummyHead = new ListNode();
        ListNode newCur = dummyHead;
        int carry = 0;
        // 只要有一条链表没走到头就继续走，已经走到头的链表就设置为0且不移动
        while (cur1 != null || cur2 != null) {
            int i1 = cur1 == null ? 0 : cur1.val;
            int i2 = cur2 == null ? 0 : cur2.val;
            int i = (i1 + i2 + carry) % 10;
            carry = (i1 + i2 + carry) / 10;
            newCur.next = new ListNode(i);
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
            newCur = newCur.next;
        }
        // 最后可能还有进位
        if (carry > 0) {
            newCur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
