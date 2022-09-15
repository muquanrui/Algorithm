package ink.vor.test.oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author muquanrui
 * @date 2022/9/15 18:26
 */

public class Test04 {
    public static void main(String[] args) {
       try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
           String[] inputs = br.readLine().split(" ");
           int snowTime = Integer.parseInt(inputs[0]);
           int heightLimit = Integer.parseInt(inputs[1]);
           List<int[]> snows = new ArrayList<>();
           for (int i = 0; i < snowTime; i++) {
               inputs = br.readLine().split(" ");
               int[] snow = new int[2];
               snow[0] = Integer.parseInt(inputs[0]);
               snow[1] = Integer.parseInt(inputs[1]);
               snows.add(snow);
           }
           System.out.println(getTotalLength(snows, heightLimit));
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public static int getTotalLength(List<int[]> snows, int heightLimit) {
        Collections.sort(snows, (snow1, snow2) -> Integer.compare(snow1[0], snow2[0]));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] arr : snows) {
            min = Math.min(min, arr[0]);
            max = Math.max(max, arr[1]);
        }
        int[] count = new int[max - min];
        for (int[] arr : snows) {
            for (int i = arr[0]; i < arr[1]; i++) {
                count[i]++;
            }
        }
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= heightLimit) {
                res++;
            }
        }
        return res;
    }
}
