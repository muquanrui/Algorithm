package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/27 15:07
 */
public class Offer58_2 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
