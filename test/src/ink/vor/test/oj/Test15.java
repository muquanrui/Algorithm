package ink.vor.test.oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author muquanrui
 * @date 2022/9/27 19:40
 */

public class Test15 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            inputs = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }
            System.out.println(solve(arr, k));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int solve(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            set.add(i);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int occur = entry.getValue();
            if (occur == 1) {
                continue;
            }
            int count = 0;
            int tmp = i;
            for (int j = 1; j < occur; j++) {
                while (set.contains(tmp)) {
                    tmp += k;
                    count++;
                }
                res += count;
                set.add(tmp);
            }
        }
        return res;
    }
}
