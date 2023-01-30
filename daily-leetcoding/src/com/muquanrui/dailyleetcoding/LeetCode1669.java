package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/30 18:17
 */

public class LeetCode1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur1 = list1;
        for (int i = 0; i < a - 1; i++) {
            cur1 = cur1.next;
        }
        ListNode cur2 = cur1.next;
        for (int i = a - 1; i < b; i++) {
            cur2 = cur2.next;
        }
        cur1.next = list2;
        while (cur1.next != null) {
            cur1 = cur1.next;
        }
        cur1.next = cur2;
        return list1;
    }
}
