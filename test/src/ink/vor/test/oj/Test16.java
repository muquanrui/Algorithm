package ink.vor.test.oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author muquanrui
 * @date 2022/9/27 20:14
 */

public class Test16 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int[][] grass = new int[n][m];
            for (int i = 0; i < n; i++) {
                inputs = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    grass[i][j] = Integer.parseInt(inputs[j]);
                }
            }
            int q = Integer.parseInt(br.readLine());
            int[][] removeGrass = new int[q][4];
            for (int i = 0; i < q; i++) {
                inputs = br.readLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    removeGrass[i][j] = Integer.parseInt(inputs[j]);
                }
            }
            System.out.println(solve(grass, removeGrass));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int solve(int[][] grass, int[][] removeGrass) {
        Arrays.sort(removeGrass, (int[] arr1, int[] arr2) -> Integer.compare(arr1[0], arr2[0]));
        int res = 0;
        for (int k = 0; k < removeGrass.length; k++) {
            int x = removeGrass[k][1];
            int y = removeGrass[k][2];
            int h = removeGrass[k][3];
            if (k > 0) {
                int seconds = removeGrass[k][0] - removeGrass[k - 1][0];
                for (int[] g : grass) {
                    for (int j = 0; j < grass[0].length; j++) {
                        g[j] += seconds;
                    }
                }
            }
            for (int i = y; i < grass[0].length && i <= y + 2; i++) {
                res += grass[x][i] - h >= 0 ? h : grass[x][i];
                grass[x][i] = grass[x][i] - h >= 0 ? grass[x][i] - h : 0;
            }
            for (int i = y - 1; i >= 0  && i >= y - 2; i++) {
                res += grass[x][i] - h >= 0 ? h : grass[x][i];
                grass[x][i] = grass[x][i] - h >= 0 ? grass[x][i] - h : 0;
            }
            for (int i = x + 1; i < grass.length  && i <= x + 2; i++) {
                res += grass[i][y] - h >= 0 ? h : grass[i][y];
                grass[i][y] = grass[i][y] - h >= 0 ? grass[i][y] - h : 0;
            }
            for (int i = x - 1; i >= 0  && i <= x + 2; i++) {
                res += grass[i][y] - h >= 0 ? h : grass[i][y];
                grass[i][y] = grass[i][y] - h >= 0 ? grass[i][y] - h : 0;
            }
        }
        return res;
    }
}
