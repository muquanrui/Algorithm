package ink.vor.top101;

import java.util.ArrayList;

/**
 * @author muquanrui
 * @date 2022/4/16 20:35
 */
public class BM74 {
    private ArrayList<String> resList = new ArrayList<>();
    private StringBuilder sb;

    public ArrayList<String> restoreIpAddresses (String s) {
        sb = new StringBuilder(s);
        backtracking(0, 0);
        return resList;
    }

    private void backtracking(int start, int dotCount) {
        if (dotCount == 3) {
            if (start < sb.length() && isValid(sb.substring(start, sb.length()))) {
                resList.add(new String(sb));
            }
            return;
        }

        for (int i = start + 1; i < start + 4 && i < sb.length(); i++) {
            if (isValid(sb.substring(start, i))) {
                sb.insert(i, '.');
                System.out.println(sb.toString());
                backtracking(i + 1, dotCount + 1);
                sb.deleteCharAt(i);
            } else {
                break;
            }
        }
    }

    private boolean isValid(String str) {
        if (str.length() <= 3 && str.charAt(0) != '0' || str.length() == 1) {
            int i = Integer.parseInt(str);
            if (i >= 0 && i <= 255) {
                return true;
            }
        }
        return false;
    }
}
