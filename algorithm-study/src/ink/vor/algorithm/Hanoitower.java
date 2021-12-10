package ink.vor.algorithm;

/**
 * @author muquanrui
 * @date 15/11/2021 08:35
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(5, 'A', 'B', 'C');
    }
    public static void hanoitower(int num, char A, char B, char C) {
        if (num == 1) {
            System.out.println("Hanoitower No." + num + " from " + A + "to " + C);
        } else {
            hanoitower(num - 1, A, C, B);
            System.out.println("Hanoitower No." + num + " from " + A + "to " + B);
            hanoitower(num - 1, B, A, C);
        }
    }
}
