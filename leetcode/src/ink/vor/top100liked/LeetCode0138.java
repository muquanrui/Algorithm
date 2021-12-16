package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 16/12/2021 16:51
 */
public class LeetCode0138 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.next = null;
        node2.random = node2;
        Node temp = copyRandomList(node1);
        if (temp == null) {
            System.out.println("null");
        } else {
            while (temp != null) {
                System.out.print(temp.val + "->");
                temp = temp.next;
            }
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        Node tempNew = newHead;
        Node beforeTempOld = head;
        Node tempOld = head.next;

        Node tempHelp = new Node(beforeTempOld.val);
        tempNew.random = beforeTempOld.random;
        beforeTempOld.next = tempHelp;
        tempHelp.next = tempOld;
        tempHelp.random = tempNew;

        while (tempOld != null) {
            tempNew.next = new Node(tempOld.val);

            beforeTempOld = tempOld;
            tempNew = tempNew.next;
            tempOld = tempOld.next;

            tempHelp = new Node(beforeTempOld.val);
            tempNew.random = beforeTempOld.random;
            beforeTempOld.next = tempHelp;
            tempHelp.next = tempOld;
            tempHelp.random = tempNew;
        }

        tempNew = newHead;
        while (tempNew != null) {
            if (tempNew.random != null) {
                tempNew.random = tempNew.random.next.random;
            }
            tempNew = tempNew.next;
        }

        tempOld = head;
        while (tempOld != null) {
            tempOld.next = tempOld.next.next;
            tempOld = tempOld.next;
        }

        return newHead;
    }
}
