package ink.vor.search;

/**
 * @author muquanrui
 * @date 31/10/2021 15:53
 */
public class InsertValueSearch {

    public static void main(String[] args) {

		int [] arr = new int[100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}

//        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };

        int index = insertValueSearch(arr, 0, arr.length - 1, 23);
        //int index = binarySearch(arr, 0, arr.length, 1);
        System.out.println("index = " + index);

        //System.out.println(Arrays.toString(arr));
    }

    //编写插值查找算法
    //说明：插值查找算法，也要求数组是有序的
    /**
     *
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 查找值
     * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[left] || findVal > arr[right]) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        if (findVal < midValue) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        }
        else if (findVal > midValue) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        }
        else {
            return mid;
        }
    }
}

