package ink.vor.top100liked;

import java.util.*;

/**
 * @author muquanrui
 * @date 07/01/2022 16:45
 */
public class LeetCode0438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        int left = 0;
        int[] sCount = new int[26];
        for (int right = 0; right < s.length(); right++) {
            int ch = s.charAt(right) - 'a';
            if (pCount[ch] == 0) {
                left = right + 1;
                sCount = new int[26];
            } else {
                if (sCount[ch] < pCount[ch]) {
                    sCount[ch]++;
                    if (sCount[ch] == pCount[ch] && isSame(sCount, pCount)) {
                        res.add(left);
                    }
                } else if (sCount[ch] == pCount[ch]) {
                    sCount[ch]++;
                    while (left < right) {
                        int leftCh = s.charAt(left) - 'a';
                        sCount[leftCh]--;
                        left++;
                        if (leftCh == ch) {
                            if (isSame(sCount, pCount)) {
                                res.add(left);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean isSame(int[] sCount, int[] pCount) {
        for (int i = 0; i < sCount.length; i++) {
            if (sCount[i] != pCount[i]) {
                return false;
            }
        }
        return true;
    }
}
