package ink.vor.algorithm;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 15/11/2021 09:55
 */
public class KMPAlgorithm {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDE";
        int index = kmpAlgorithm(str1, str2);
        System.out.println("The match starts at index: " + index);
    }


    public static int kmpAlgorithm(String text, String toBeMatched) {
        return kmpSearch(text, toBeMatched, kmpPrefixTable(toBeMatched));
    }

    public static int kmpSearch(String str1, String str2, int[] kmpPrefixTable) {
        int i = 0;
        int j = 0;
        while (i < str1.length()) {
            while (j < str2.length() && str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            }
            if (j == str2.length()) {
                return i - j;
            }
            j = kmpPrefixTable[j];
            if (j == -1) {
                i++;
                j++;
            }
        }
        return -1;
    }

    //获取到一个字符串(子串) 的部分匹配值表
    public static int[] kmpPrefixTable(String str) {
        int[] table = new int[str.length()];
        table[0] = 0;
        for (int i = 1; i < table.length; i++) {
            int j = table[i - 1];
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = table[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            table[i] = j;
        }

        for (int i = table.length - 1; i > 0; i--) {
            table[i] = table[i - 1];
        }
        table[0] = -1;
        return table;
    }

    public static int bruteForceMatch(String text, String toBeMatched) {
        int i = 0;
        int j = 0;
        int index = -1;
        while (i < text.length()) {
            index = i;
            while (j < toBeMatched.length() && text.charAt(i) == toBeMatched.charAt(j)) {
                i++;
                j++;
            }
            if (j == toBeMatched.length()) {
                return index;
            }
            i = index + 1;
            j = 0;
        }
        return index;
    }
}
