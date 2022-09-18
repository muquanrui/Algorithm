package ink.vor.test.oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author muquanrui
 * @date 2022/9/18 19:48
 */

public class Test10 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String input;
            List<int[]> values = new ArrayList<>();
            while (!(input = br.readLine()).equals("")) {
                String[] strings = input.split(",");
                int[] nums = new int[2];
                nums[0] = Integer.parseInt(strings[0]);
                nums[1] = Integer.parseInt(strings[1]);
                values.add(nums);
            }
            System.out.println(solve(values));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int solve(List<int[]> values) {
        Collections.sort(values, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        int res = 0;
        int[] dp = new int[values.size()];
        dp[0] = 0;
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i)[0] == values.get(i - 1)[0]) {
                continue;
            }
            if (values.get(i)[1] > values.get(i - 1)[1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return res;
    }
}
