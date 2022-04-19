package ink.vor.top101;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/4/19 22:46
 */
public class BM95 {
    public int candy (int[] arr) {
        return candies(arr);
    }

    public int candies(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
                candies[i - 1] = candies[i] + 1;
            }
        }
        return Arrays.stream(candies).sum();
    }
}
