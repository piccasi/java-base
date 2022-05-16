package algorithm.sort;

import java.util.Arrays;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: FindTopK
 * @Since: 1.0
 * @Version: v1.0
 * @Date: 2022/5/8 11:12 上午
 * @Author: piccasi@163.com
 * @Description:
 **/

public class FindTopK {


    public static int getTopK(int[] arr, int k, String orderBy) {
        if (k == 1) return arr[0];

        int offset = 1;
        for (int i = 0; i < arr.length; i++) {
            if((i+1) >= arr.length){
                if (offset >= k) return arr[i];
                else return -1;
            }
            if(compare(arr[i], arr[i+1], orderBy)) {
                offset++;
                if (offset >= k){
                    return arr[i+1];
                }
            }
        }
        return -1;
    }

    public static int quickSort(int[] arr, int start, int end, int k, String orderBy) {
        int pivotIndex = -1;

        if(start < end) {
            pivotIndex = pivotIndexLookUp(arr, start, end, orderBy);

            if(pivotIndex > k-1) {
                pivotIndex = quickSort(arr, start, pivotIndex - 1, k, orderBy);
            } else if(pivotIndex < k-1){
                pivotIndex = quickSort(arr, pivotIndex + 1, end, k, orderBy);
            }
        }
        return pivotIndex;
    }

    public static int getTopk2(int[] arr, int k, String orderBy){

        int pivotIndex = quickSort(arr, 0, arr.length - 1, k,orderBy);
        return arr[pivotIndex];

    }

    public static int pivotIndexLookUp(int [] arr, int start, int end, String orderBy){
        //选取第一个元素作为pivot
        int pivot = arr[start];
        int pivotIndex = start;
        //offset是用来寻找pivot的正确位置，因为选取的是第一个，第一个元素不用比较，所以从第二个开始
        int offset = pivotIndex + 1;

        for (int i = offset; i <= end; i++) {
            if (compare(arr[i], pivot, orderBy)) {
                QuickSort.swap(arr, i, offset);
                offset++;
            }
        }

        //这次交换很关键，经过上面的循环后offset前面的元素都比pivot小，offset当前指向的元素则大于或等于pivot，所以把pivot放在offset-1的位置就是正确的位置
        QuickSort.swap(arr, pivotIndex, offset - 1);
        pivotIndex = offset - 1;

        return pivotIndex;
    }

    public static boolean compare(int left, int right, String orderBy){
        if("asc".equals(orderBy)) {
            return  left < right;

        } else if("desc".equals(orderBy)) {
            return left > right;
        }
        return false;
    }

    public static void bubbleTopK(int[] arr, int k, String orderBy){
        BubbleSort.bubbleSort(arr, k, orderBy);
        QuickSort.printArr(arr);
    }

    /**
     * 使用堆排序实现topK
     * @param arr 原始数据
     * @param k top k
     * @return 前K大的元素
     */
    public static int[] getTopKByHeadSort(int [] arr, int k){
        HeapSort heapSort = new HeapSort(arr, k);
        int [] topK = heapSort.getArr();
        System.out.println("topK: " + Arrays.toString(topK));

        int firstNodeIndex = (k >> 1) - 1;
        // 把前K个元素构造成小顶堆，构造完成后第一个元素已经是最大值
        for (int i = firstNodeIndex; i >= 0; i--) {
            heapSort.minHeapify(i, k-1);
        }

        System.out.println("asc: " + Arrays.toString(topK));

        //小堆顶的堆顶元素为最小值，最小与k后面的元素做比较，比堆顶元素大则交换后重新构建前k个元素的小堆顶
        for (int i = k; i < arr.length; i++) {
            if(topK[0] < arr[i]){
                topK[0] = arr[i];
                heapSort.minHeapify(0, k-1);
            }
        }

        System.out.println("sort: " + Arrays.toString(topK));
        return topK;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 3, 5, 6, 7, 1, 6, 6};
        QuickSort.quickSort(arr, 0, arr.length - 1, "desc");

        QuickSort.printArr(arr);
        int topK = getTopK(arr, 4, "desc");

        System.out.println(topK);

        topK = getTopk2(arr, 4, "desc");

        System.out.println(topK);

        int[] arr1 = {4, 5, 3, 5, 6, 7, 1, 6, 6};
        bubbleTopK(arr1, 2, "asc");

        int[] arr2 = {4, 5, 3, 5, 6, 7, 1, 6, 6};

        int[] topKs = getTopKByHeadSort(arr2, 4);
        System.out.println(Arrays.toString(topKs));

    }
}
