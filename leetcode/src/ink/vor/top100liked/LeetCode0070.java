package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 10/12/2021 12:43
 */
public class LeetCode0070 {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        int[] count = new int[n];
        for (int i  = 0; i < n; i++) {
            if (i == 0) {
                count[i] = 1;
            } else if (i == 1) {
                count[i] = 2;
            } else {
                count[i] = count[i - 1] + count[i - 2];
            }
        }
        return count[n - 1];
    }
}
