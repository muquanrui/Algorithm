package ink.vor.top101;

import java.util.ArrayList;

/**
 * @author muquanrui
 * @date 31/03/2022 19:49
 */
public class BM5 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int k = lists.size();
        if (k == 0) {
            return null;
        }
        while (k > 1) {
            int incr = (k + 1) / 2;
            for (int i = 0; i < k / 2; i++) {
                lists.set(i, mergeLists(lists.get(i), lists.get(i + incr)));
            }
            k = incr;
        }
        return lists.get(0);
    }

    private ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newHead = null;
        if (list1.val <= list2.val) {
            newHead = list1;
            newHead.next = mergeLists(list1.next, list2);
        } else {
            newHead = list2;
            newHead.next = mergeLists(list1, list2.next);
        }
        return newHead;
    }
}
