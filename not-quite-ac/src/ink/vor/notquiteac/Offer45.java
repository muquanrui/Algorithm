package ink.vor.notquiteac;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/7/18 16:57
 */
public class Offer45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (s1, s2) -> (new String(s1 + s2).compareTo(new String(s2 + s1))));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
