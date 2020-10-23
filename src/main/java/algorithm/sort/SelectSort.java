package algorithm.sort;

/**
 * @author zengfanyu
 * @date 2020/3/12 14:22
 * 在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小（大）元素梵高已排序序列末尾
 * 以此类推，直到所有元素均排序完毕
 */
public class SelectSort {
    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
}
