package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/12/17 20:34
 */

public class LeetCode1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        for (int[] arr : groups) {
            boolean flag = true;
            while (flag) {
                int curI = i;
                while (curI < nums.length && nums[curI] != arr[0]) {
                    curI++;
                }
                if (curI >= nums.length) {
                    return false;
                }
                int startCurI = curI;
                int j = 0;
                for (; j < arr.length && curI < nums.length; j++) {
                    if (arr[j] != nums[curI]) {
                        break;
                    }
                    curI++;
                }
                if (j != arr.length) {
                    i = startCurI + 1;
                } else {
                    i = curI;
                    flag = false;
                }
            }
        }
        return true;
    }
}
