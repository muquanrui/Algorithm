package ink.vor.backtracking;

import java.util.*;

/**
 * @author muquanrui
 * @date 2022/5/8 22:48
 */
public class LeetCode0332 {
    LinkedList<String> resList = new LinkedList<>();
    Map<String, Map<String, Integer>> map = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket: tickets) {
            if (map.containsKey(ticket.get(0))) {
                Map<String, Integer> tmpMap = map.get(ticket.get(0));
                tmpMap.put(ticket.get(1), tmpMap.getOrDefault(ticket.get(1), 0) + 1);
            } else {
                Map<String, Integer> tmpMap = new TreeMap<>();
                tmpMap.put(ticket.get(1), 1);
                map.put(ticket.get(0), tmpMap);
            }
        }
        resList.addLast("JFK");
        backtracking(tickets);
        return resList;
    }
    boolean flag = false;
    private boolean backtracking(List<List<String>> tickets) {
        if (resList.size() == tickets.size() + 1) {
            return true;
        }
        Map<String, Integer> tmpMap = map.get(resList.getLast());
        if (tmpMap == null) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : tmpMap.entrySet()) {
            int count = entry.getValue();
            if (count > 0) {
                count--;
                entry.setValue(count);
                resList.addLast(entry.getKey());
                if (backtracking(tickets)) {
                    return true;
                }
                count++;
                entry.setValue(count);
                resList.removeLast();
            }
        }
        return false;
    }
}
