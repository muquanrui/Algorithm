package ink.vor.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 08/02/2022 22:45
 */
public class LeetCode0202 {
    public boolean isHappy(int n) {
        Set<Integer> repeatSet = new HashSet<>();
        while (!repeatSet.contains(n)) {
            repeatSet.add(n);
            n = helper(n);
        }
        return n == 1;
    }

    public int helper(int n) {
        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n = n / 10;
        }
        return res;
    }
}
