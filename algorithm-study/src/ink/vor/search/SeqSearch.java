package ink.vor.search;

/**
 * @author muquanrui
 * @date 31/10/2021 15:45
 */
public class SeqSearch {

    public static void main(String[] args) {
        int arr[] = { 1, 9, 11, -1, 34, 89 };// 没有顺序的数组
        int index = seqSearch(arr, 11);
        if(index == -1) {
            System.out.println("没有找到到");
        } else {
            System.out.println("找到，下标为=" + index);
        }
    }

    /**
     * 这里我们实现的线性查找是找到一个满足条件的值，就返回
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr, int value) {
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] == value) {
               return i;
           }
       }
       return -1;
    }

}

