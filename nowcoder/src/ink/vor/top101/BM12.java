package ink.vor.top101;

import java.util.*;

/**
 * @author muquanrui
 * @date 01/04/2022 23:43
 */
public class BM12 {
    public ListNode sortInList (ListNode head) {
        // write code here
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            list.addLast(cur);
            cur = cur.next;
        }
        list.sort((o1, o2) -> Integer.compare(o1.val, o2.val));
        ListNode newHead = list.removeFirst();
        cur = newHead;
        while (!list.isEmpty()) {
            cur.next = list.removeFirst();
            cur = cur.next;
        }
        cur.next = null;
        return newHead;
    }
}
