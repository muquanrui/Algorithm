package ink.vor.newcoder.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author muquanrui
 * @date 2022/8/8 13:54
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (set.contains(cur)){
                continue;
            }
            list.add(cur);
        }
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }
}
