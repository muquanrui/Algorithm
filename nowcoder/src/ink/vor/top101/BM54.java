package ink.vor.top101;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/4/13 23:42
 */
public class BM54 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < num.length && num[i] <= 0; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    resList.add(new ArrayList<Integer>(Arrays.asList(num[i], num[left], num[right])));
                    while (left < right && num[left] == num[++left]);
                    while (left < right && num[right] == num[--right]);
                }
            }
        }
        return resList;
    }
}
