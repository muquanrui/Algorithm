package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author muquanrui
 * @date 18/12/2021 19:19
 */
public class LeetCode0148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode newHead = new ListNode(list.get(0).val);
        temp = newHead;
        for (int i = 1; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i).val);
            temp = temp.next;
        }
        return newHead;
    }
}
