package sort;

/**
 * @author zengfanyu
 * @date 2020/3/12 15:30
 * 希尔排序的思想是采用插入排序的方法，先让数组中任意间隔为 h 的元素有序;
 * 刚开始 h 的大小可以是 h = n / 2,接着让 h = n / 4，让 h 一直缩小;
 * 当 h = 1 时，也就是此时数组中任意间隔为1的元素有序,此时的数组就是有序的了;
 */
public class ShellSort {
    public static int[] shellSort(int[] arr) {
        int gap = arr.length / 2;
        for (; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int preIndex = i;
                int current = arr[i];
                while (preIndex - gap >= 0 && arr[preIndex - gap] > current) {
                    arr[preIndex] = arr[preIndex - gap];
                    preIndex = preIndex - gap;
                }
                arr[preIndex] = current;
            }
        }
        return arr;
    }
}
