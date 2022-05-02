package ink.vor.hashtable;

/**
 * @author muquanrui
 * @date 2022/5/2 15:36
 */
public class LeetCode0383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dic = new int[26];
        for (char ch: magazine.toCharArray()) {
            dic[ch - 'a'] += 1;
        }
        for (char ch: ransomNote.toCharArray()) {
            dic[ch - 'a'] -= 1;
            if (dic[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
