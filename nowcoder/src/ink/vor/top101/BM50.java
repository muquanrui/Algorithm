package ink.vor.top101;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/4/13 17:07
 */
public class BM50 {
    public int[] twoSum (int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target - numbers[i]) != null) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[]{};
    }
}
