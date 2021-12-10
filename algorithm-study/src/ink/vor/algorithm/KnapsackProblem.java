package ink.vor.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 15/11/2021 08:55
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        Item item1 = new Item(1, 1, 1500);
        Item item2 = new Item(2, 4, 3000);
        Item item3 = new Item(3, 3, 2000);

        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        int itemCount = items.size();
        int bagSize = 4;

        int[][] valueTable = new int[itemCount + 1][bagSize + 1];

        String[][] results = new String[itemCount + 1][bagSize + 1];
        for (int i = 0; i < itemCount + 1; i++) {
            results[i][0] = ".";
        }
        for (int j = 0; j < bagSize + 1; j++) {
            results[0][j] = ".";
        }

        String answer = "";

        for (int i = 1; i <= itemCount; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < items.get(i - 1).weight) {
                    valueTable[i][j] = valueTable[i-1][j];
                    results[i][j] = results[i-1][j];
                } else {
                    int last = valueTable[i-1][j];
                    int cur = items.get(i - 1).value + valueTable[i-1][j-items.get(i - 1).weight];
                    if (cur > last) {
                        valueTable[i][j] = cur;
                        results[i][j] = "Item " + items.get(i - 1).no + " in. " + results[i-1][j-items.get(i - 1).weight];
                        answer = results[i][j];
                    } else {
                        valueTable[i][j] = last;
                        results[i][j] = results[i-1][j];
                    }
                }
            }
        }

        for (int[] arr: valueTable){
            System.out.println(Arrays.toString(arr));
        }
        for (String[] arr: results){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("Answer is: " + answer);
    }
}

class Item {
    int no;
    int weight;
    int value;

    public Item(int n, int w, int v) {
        no = n;
        weight = w;
        value = v;
    }
}
