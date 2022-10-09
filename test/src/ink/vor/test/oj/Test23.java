package ink.vor.test.oj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/10/9 16:45
 */

public class Test23 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int q = Integer.parseInt(inputs[1]);
            int[][] reverse = new int[q][2];
            for (int i = 0; i < q; i++) {
                inputs = br.readLine().split(" ");
                reverse[i][0] = Integer.parseInt(inputs[0]);
                reverse[i][1] = Integer.parseInt(inputs[1]);
            }
            int[] res = solve(n, q, reverse);
            for (int i : res) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] solve(int n, int q, int[][] reverse) {
        int[] res = new int[q];
        int indexR = 0;
        int[] status = new int[n];
        for (int[] op : reverse) {
            status[op[0] - 1] += 1;
            if (op[1] < n) {
                status[op[1]] += 1;
            }
            int[] temp = new int[n];
            temp[0] = status[0];
            for (int i = 1; i < n; i++) {
                temp[i] = temp[i - 1] + status[i];
            }
            int curRes = 0;
            for (int i : temp) {
                if (i % 2 == 0) {
                    curRes++;
                }
            }
            res[indexR++] = curRes;
        }
        return res;
    }
}
