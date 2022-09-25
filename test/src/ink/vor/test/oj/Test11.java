package ink.vor.test.oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/9/24 19:26
 */

public class Test11 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");
            int[] candies = new int[length];
            for (int i = 0; i < candies.length; i++) {
                candies[i] = Integer.parseInt(inputs[i]);
            }
            System.out.println(solve(candies));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int[] candies) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : candies) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res += entry.getValue() - 1;
        }
        return res;
    }
}
