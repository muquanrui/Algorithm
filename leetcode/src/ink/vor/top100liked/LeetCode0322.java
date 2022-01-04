package ink.vor.top100liked;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 04/01/2022 09:43
 */
public class LeetCode0322 {
    public static void main(String[] args) {
        LeetCode0322 solution = new LeetCode0322();
//        int[] coins = {186,419,83,408};
//        System.out.println(solution.coinChange(coins, 6249));
        int[] coins = {411,412,413,414,415,416,417,418,419,420,421,422};
        System.out.println(solution.coinChange(coins, 9864));
    }

    //    public int coinChange(int[] coins, int amount) {
//        fewest = Integer.MAX_VALUE;
//        Arrays.sort(coins);
//        return recursiveMinus(coins, coins.length - 1, amount, 0) ? fewest : -1;
//    }
//
//    public int fewest;
//    public boolean recursiveMinus(int[] coins, int start, int amount, int coinCount) {
//        if (start < 0) {
//            return false;
//        }
//        if (amount % coins[start] == 0) {
//            fewest = Math.min(coinCount + amount / coins[start], fewest);
//            return true;
//        }
//        boolean isChange = false;
//        for (int j = amount / coins[start]; j >= 0; j--) {
//            if (coinCount + j  < fewest - 1) {
//                boolean temp = recursiveMinus(coins, start - 1, amount - coins[start] * j, coinCount + j);
//                isChange = isChange ? isChange : temp;
//            } else {
//                break;
//            }
//        }
//        return isChange;
//    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin: coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
