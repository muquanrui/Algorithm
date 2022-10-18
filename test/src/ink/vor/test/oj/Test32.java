package ink.vor.test.oj;

import java.util.Arrays;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/10/18 16:06
 */

public class Test32 {
    public static void main(String[] args) {
        System.out.println(getMostVisited(10, Arrays.asList(1,5,10,3)));
    }
    public static int getMostVisited(int n, List<Integer> sprints) {
        // Write your code here
        int[] prefixSum = new int[n];
        for (int i = 1; i < sprints.size(); i++) {
            int num1 = sprints.get(i - 1) - 1;
            int num2 = sprints.get(i) - 1;
            int start = Math.min(num1, num2);
            int end = Math.max(num1, num2);
            prefixSum[start] += 1;
            if (end < n - 1) {
                prefixSum[end + 1] -= 1;
            }
        }
        for (int i = 1; i < n; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = prefixSum[i] > prefixSum[res] ? i : res;
        }
        return res + 1;
    }
}
