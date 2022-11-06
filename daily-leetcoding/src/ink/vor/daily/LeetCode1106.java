package ink.vor.daily;

import java.util.*;

/**
 * @author muquanrui
 * @date 2022/11/5 21:43
 */

// https://leetcode.cn/problems/parsing-a-boolean-expression/
public class LeetCode1106 {
    public boolean parseBoolExpr(String expression) {
        if (expression.equals("t")) {
            return true;
        }
        if (expression.equals("f")) {
            return false;
        }
        Character operator = expression.charAt(0);
        List<Boolean> operands = new ArrayList<>();

        String subExp = expression.substring(2, expression.length() - 1);
        int left = 0;
        int bracketCount = 0;
        for (int right = 0; right < subExp.length(); right++) {
            char ch = subExp.charAt(right);
            if (ch == '(') {
                bracketCount++;
            } else if (ch == ')') {
                bracketCount--;
            }
            if ((right == subExp.length() - 1 || subExp.charAt(right + 1) == ',') && bracketCount == 0) {
                operands.add(parseBoolExpr(subExp.substring(left, right + 1)));
                left = right + 2;
            }
        }

        if (operator == '!') {
            return not(operands);
        } else if (operator == '&') {
            return and(operands);
        } else {
            return or(operands);
        }
    }

    private boolean not(List<Boolean> flagList) {
        return !flagList.get(0);
    }

    private boolean and(List<Boolean> flagList) {
        for (boolean flag : flagList) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    private boolean or(List<Boolean> flagList) {
        for (boolean flag : flagList) {
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
