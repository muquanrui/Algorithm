package ink.vor.string;

/**
 * @author muquanrui
 * @date 2022/5/2 16:38
 */
public class Offer58_2 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
