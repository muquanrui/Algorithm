package ink.vor.test.oj;

/**
 * @author muquanrui
 * @date 2022/10/12 14:05
 */

public class Test24 {
    public int compareVersion (String version1, String version2) {
        // write code here
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length && i < v2.length) {
            int vi1 = Character.isDigit(v1[i].charAt(0)) ? Integer.parseInt(v1[i]) : 0;
            int vi2 = Character.isDigit(v2[i].charAt(0)) ? Integer.parseInt(v2[i]) : 0;
            if (vi1 > vi2) {
                return 1;
            } else if (vi1 < vi2) {
                return -1;
            }
            i++;
        }
        for (int j = i; j < v1.length; j++) {
            int vi1 = Character.isDigit(v1[i].charAt(0)) ? Integer.parseInt(v1[i]) : 0;
            if (vi1 > 0) {
                return 1;
            }
        }
        for (int j = i; j < v2.length; j++) {
            int vi2 = Character.isDigit(v2[i].charAt(0)) ? Integer.parseInt(v2[i]) : 0;
            if (vi2 > 0) {
                return -1;
            }
        }
        return 0;
    }
}
