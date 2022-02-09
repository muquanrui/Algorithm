package ink.vor.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 09/02/2022 18:24
 */
public class LeetCode0383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] occurrenceIndex = new int[26];
        for (char ch: ransomNote.toCharArray()) {
            int index = magazine.indexOf(ch, occurrenceIndex[ch - 'a']);
            if (index == -1) {
                return false;
            }
            occurrenceIndex[ch - 'a'] = index + 1;
        }
        return true;
    }
}
