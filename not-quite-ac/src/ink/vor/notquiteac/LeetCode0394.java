package ink.vor.notquiteac;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/6/27 22:49
 */
public class LeetCode0394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Deque<Integer> stack_multi = new LinkedList<>();
        Deque<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.pop() + tmp);
            } else if(c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
