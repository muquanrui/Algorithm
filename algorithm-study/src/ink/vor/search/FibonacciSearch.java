package ink.vor.search;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 31/10/2021 16:38
 */
public class FibonacciSearch {

    public static int maxSize = 20;
    public static void main(String[] args) {
        int [] arr = {1,8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibSearch(arr, 1234));// 0

    }

    //因为后面我们mid=low+F(k-1)-1，需要使用到斐波那契数列，因此我们需要先获取到一个斐波那契数列
    //非递归方法得到一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //编写斐波那契查找算法
    //使用非递归的方式编写算法
    /**
     *
     * @param arr  数组
     * @param key 我们需要查找的关键码(值)
     * @return 返回对应的下标，如果没有-1
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;

        int fib[] = fib();

        while (arr.length > fib[k]) {
            k++;
        }

        int temp[] = Arrays.copyOf(arr, fib[k]);

        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            int mid = low + fib[k - 1] - 1;
            int midVal = temp[mid];

            if (key < midVal) {
                high = mid - 1;
                k -= 1;
            }
            else if (key > midVal) {
                low = mid + 1;
                k -= 2;
            }
            else {
                if (mid >= high) {
                    return high;
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
}

