package ink.vor.test.oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author muquanrui
 * @date 2022/9/15 19:53
 */

public class Test05 {
    public static void main(String[] args) {
        // try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        //     int count = Integer.parseInt(br.readLine());
        //     for (int i = 0; i < count; i++) {
        //         String[] inputs = br.readLine().split(" ");
        //         int p = Integer.parseInt(inputs[1]);
        //         String str = br.readLine();
        //         System.out.println(convertStringToP(str, p));
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        System.out.println(convertStringToP("cdccdc", 2));
    }

    public static int convertStringToP(String s, int p) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i += p) {
            int left = i;
            int right = i + p - 1;
            int countChange = 0;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    int count1 = 0;
                    for (int j = left - i; j < s.length(); j += p) {
                        if (s.charAt(j) != s.charAt(right)) {
                            count1++;
                        }
                    }
                    int count2 = 0;
                    for (int j = right - i; j < s.length(); j += p) {
                        if (s.charAt(j) != s.charAt(left)) {
                            count2++;
                        }
                    }
                    countChange += Math.min(count1, count2);
                }
                left++;
                right--;
            }
            res = Math.min(res, countChange);
        }
        return res;
    }
}
