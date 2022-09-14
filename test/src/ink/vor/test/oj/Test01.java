package ink.vor.test.oj;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * @author muquanrui
 * @date 2022/9/14 18:49
 */


class ListNode<T> {
    public T data;
    public ListNode next;
}

public class Test01 {
    /* Write Code Here */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        ListNode<Integer> dummyHead = new ListNode<>();
        dummyHead.next = head;
        ListNode<Integer> cur = dummyHead;
        for (int i = 1; i < left; i++) {
            cur = cur.next;
        }
        ListNode<Integer> start = cur;
        ListNode<Integer> end = cur.next;
        ListNode<Integer> pre = null;
        cur = cur.next;
        ListNode<Integer> next;
        for (int i = left; i <= right; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = pre;
        end.next = cur;
        return dummyHead.next;
    }
}
