package ink.vor.top101;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 09/04/2022 23:29
 */
public class BM45 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> max = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (queue.size() > 0 && i >= size && queue.peekFirst() == num[i - size]) {
                queue.pollFirst();
            }
            while (queue.size() > 0 && queue.peekLast() < num[i]) {
                queue.pollLast();
            }
            queue.offer(num[i]);
            if (i >= size - 1) {
                max.add(queue.peekFirst());
            }
        }
        return max;
    }
}
