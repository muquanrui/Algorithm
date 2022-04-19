package ink.vor.top101;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/4/19 22:45
 */
public class BM92 {
    public int maxLength (int[] arr) {
        // write code here
        if (arr.length == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < arr.length; right++) {
            int cur = arr[right];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            if (map.get(cur) == 1) {
                res = Math.max(res, right - left + 1);
            }
            while (map.get(cur) > 1) {
                int lNum = arr[left++];
                map.put(lNum, map.get(lNum) - 1);
            }
        }
        return res;
    }
}
