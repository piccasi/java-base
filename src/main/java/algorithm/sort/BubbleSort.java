package algorithm.sort;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: BubbleSort
 * @Since: 1.0
 * @Version: v1.0
 * @Date: 2022/5/9 11:16 下午
 * @Author: piccasi@163.com
 * @Description:
 **/

public class BubbleSort {

    public static void bubbleSort(int[] arr, int k, String orderBy){
        for (int i = 0; i < k; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (QuickSort.compare(arr[i], arr[j], orderBy)){
                    QuickSort.swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int []arr = {3,5,7,1,2,-1};
        bubbleSort(arr, arr.length,  "asc");
        QuickSort.printArr(arr);
    }
}
