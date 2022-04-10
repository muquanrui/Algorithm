package ink.vor.top101;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 10/04/2022 22:31
 */
public class BM49 {
    public int solve (String s) {
        Deque<Integer> operands = new LinkedList<>();
        Deque<Character> operators = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                String str = s.substring(start, i);
                i--;
                int num = Integer.parseInt(str);
                if (!operators.isEmpty() && operators.peek() == '*') {
                    operands.push(num * operands.pop());
                    operators.pop();
                } else {
                    operands.push(num);
                }
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    int op1 = operands.pop();
                    int op2 = operands.pop();
                    char oper = operators.pop();
                    if (oper == '+') {
                        operands.push(op2 + op1);
                    } else if (oper == '-') {
                        operands.push(op2 - op1);
                    } else if (oper == '*') {
                        operands.push(op2 * op1);
                    }
                }
                operators.pop();
            } else {
                operators.push(ch);
            }
        }
        while (!operators.isEmpty()) {
            int op1 = operands.pollLast();
            int op2 = operands.pollLast();
            char oper = operators.pollFirst();
            if (oper == '+') {
                operands.offerLast(op1 + op2);
            } else if (oper == '-') {
                operands.offerLast(op1 - op2);
            } else if (oper == '*') {
                operands.offerLast(op1 * op2);
            }
        }
        return operands.peek();

    }
}
