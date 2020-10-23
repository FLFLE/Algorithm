package sort;

import java.util.Random;

/**
 * @author zengfanyu
 * @date 2020/3/12 19:24
 */
public class TestSort {
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {17, 5, 3, 20, 23, 6, 11, 8, 9, 4};
//        print(BubbleSort.bubbleSort(arr));
//        print(InsertSort.insertSort(arr));
//          print(QuickSort.quickSort(arr,0,arr.length-1));
        print(SelectSort.selectSort(arr));
//          print(ShellSort.shellSort(arr));
        System.out.println(new Random().nextInt(15));
    }
}
