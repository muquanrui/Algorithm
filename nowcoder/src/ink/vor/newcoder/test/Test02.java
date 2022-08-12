package ink.vor.newcoder.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author muquanrui
 * @date 2022/8/9 19:11
 */

/*
美式计数法是将一个数字，从低位开始每三位一组，组之间用空格分隔的一种计数方式；例如按照美式计数方式为。
学会了美式计数方式后，小想创建属于自己的计数方式——式计数法；他想将数字,从低位起，每位数字一组，组之间用"  "分隔。例如，,因此按照式计数法则应该为；
现在给出和，请你输出按照式计数法的值。

输入描述:
第一行给出正整数,代表测试用例；
随后行，每行给出一个整数和,用空格分隔。

输出描述:
对于每一组测试用例每行单独输出按照式计数法的值。

输入例子1:
4
1 1234
2 12
3 12345
4 123456789

输出例子1:
1_2_3_4
12
12_345
1_2345_6789
*/
public class Test02 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int tests = Integer.parseInt(br.readLine());
            for (int i = 0; i < tests; i++) {
                String str = br.readLine();
                String[] test = str.split(" ");
                System.out.println(getResult(Integer.parseInt(test[0]), test[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getResult(int a, String num) {
        StringBuilder sb = new StringBuilder();
        int index = num.length() - 1;
        while (index >= 0) {
            for (int i = 0; i < a && index >= 0; i++) {
                sb.append(num.charAt(index));
                index--;
            }
            sb.append('_');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.reverse();
        return sb.toString();
    }
}
