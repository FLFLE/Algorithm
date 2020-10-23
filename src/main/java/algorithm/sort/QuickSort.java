package algorithm.sort;

/**
 * @author zengfanyu
 * @date 2020/3/12 18:52
 * 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）;
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */
public class QuickSort {
    /**
     * 以最右边元素为基准，将基准元素移至中央并分组，返回基准元素的索引
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partion(int[] arr, int left, int right) {
        int temp, pivot;
        int i, j;
        i = left;
        pivot = arr[right];
        for (j = left; j < right; j++) {
            if (arr[j] < pivot) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        arr[right] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        int key, i, j, temp;
        if (left < right) {
            key = partion(arr, left, right);
//            key = partion(arr,left,right);
            arr = quickSort(arr, left, key - 1);
            arr = quickSort(arr, key + 1, right);
        }
        return arr;
    }

    /**
     * 双向扫描
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    int partition2(int[] arr, int left, int right) {
        int pivot = arr[left];
        int m = left + 1;
        int n = right;
        while (true) {
            //向右遍历扫描
            while (m <= n && arr[m] <= pivot) m++;
            //向左遍历扫描
            while (m <= n && arr[n] >= pivot) n--;
            if (m >= n)
                break;
            //交换
            int temp = arr[m];
            arr[m] = arr[n];
            arr[n] = temp;
        }
        //把arr[j]和主元交换
        arr[left] = arr[n];
        arr[n] = pivot;
        return n;
    }
}
