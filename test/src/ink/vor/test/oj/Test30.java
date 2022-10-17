package ink.vor.test.oj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/10/16 20:21
 */

public class Test30 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            inputs = br.readLine().split(" ");
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }
            System.out.println(solve(arr, k));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int solve(Integer[] arr, int opTimes) {
        if (opTimes == 0) {
            return Arrays.stream(arr).mapToInt(n -> n).sum();
        }
        Arrays.sort(arr, (i1, i2) -> {
            return Integer.compare(i2 - count1(i2), i1 - count1(i1));
        });

        arr[0] = count1(arr[0]);

        return solve(arr, opTimes - 1);
    }

    private static int count1(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }
}
