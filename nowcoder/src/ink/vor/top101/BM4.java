package ink.vor.top101;

/**
 * @author muquanrui
 * @date 30/03/2022 23:11
 */
public class BM4 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newHead = null;
        if (list1.val <= list2.val) {
            newHead = list1;
            newHead.next = Merge(list1.next, list2);
        } else {
            newHead = list2;
            newHead.next = Merge(list1, list2.next);
        }
        return newHead;
    }
}
