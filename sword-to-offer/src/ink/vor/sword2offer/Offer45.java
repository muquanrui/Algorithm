package ink.vor.sword2offer;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/4/24 15:06
 */
public class Offer45 {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, (s1, s2) -> new String(s1 + s2).compareTo(new String(s2 + s1)));
        StringBuilder sb = new StringBuilder();
        for (String s: str) {
            sb.append(s);
        }
        return new String(sb);
    }
}
