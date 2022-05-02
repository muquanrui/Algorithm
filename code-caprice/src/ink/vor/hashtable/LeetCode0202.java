package ink.vor.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2022/5/2 11:47
 */
public class LeetCode0202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            n = getSum(n);
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        return true;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int remainder = n % 10;
            sum += remainder * remainder;
            n /= 10;
        }
        return sum;
    }
}
