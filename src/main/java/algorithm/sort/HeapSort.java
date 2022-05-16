package algorithm.sort;

import java.util.Arrays;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: HeapSort
 * @Since: 1.0
 * @Version: v1.0
 * @Date: 2022/5/13 8:31 下午
 * @Author: piccasi@163.com
 * @Description: 堆排序
 **/

public class HeapSort {
    private int[] arr;
    private int len;

    public HeapSort(int [] arr, int len){
        this.arr = Arrays.copyOf(arr, len);
        this.len = len;
    }

    public int[] getArr(){
        return arr;
    }

    /**
     * 这个函数是堆排序的关键，这里是按大顶堆的方式构建，即是堆顶元素大于等于叶子节点
     * @param index 当前堆顶序号
     * @param maxIndex  最大位置序号
     */
    public void maxHeapify(int index, int maxIndex){
        int leftIndex = (index << 1) + 1;
        int rightIndex = leftIndex + 1;
        int nextIndex = leftIndex;

        if (leftIndex > maxIndex) return;

        if (rightIndex <= maxIndex && arr[leftIndex] < arr[rightIndex]) {
            nextIndex = rightIndex;
        }

        if (arr[nextIndex] > arr[index]){
            QuickSort.swap(arr, nextIndex, index);
            maxHeapify(nextIndex, maxIndex);
        }

    }

    /**
     * 这个函数是堆排序的关键，这里是按小顶堆的方式构建，即是堆顶元素小于等于叶子节点
     * @param index 当前堆顶序号
     * @param maxIndex  最大位置序号
     */
    public void minHeapify(int index, int maxIndex){
        int leftIndex = (index << 1) + 1;
        int rightIndex = leftIndex + 1;
        int nextIndex = leftIndex;

        if (leftIndex > maxIndex) return;

        if (rightIndex <= maxIndex && arr[leftIndex] > arr[rightIndex]) {
            nextIndex = rightIndex;
        }

        if (arr[nextIndex] < arr[index]){
            QuickSort.swap(arr, nextIndex, index);
            minHeapify(nextIndex, maxIndex);
        }
    }

    public int[] heapSort(String orderBy) {
        // 计算第一个堆顶元素的位置
        int firstNodeIndex = (len >> 1) - 1;


        if ("asc".equals(orderBy)) {
            // 把整个数组构造成大顶堆，构造完成后第一个元素已经是最大值
            for (int i = firstNodeIndex; i >= 0; i--) {
                maxHeapify(i, len-1);
                System.out.println(Arrays.toString(arr));
            }

            // 第一个元素已经是最大值，与最后一个元素交换，重新构建大顶堆
            for (int i = len - 1; i > 0; i--) {
                System.out.println("before swap: " + i + " " + Arrays.toString(arr));
                QuickSort.swap(arr, 0, i);

                System.out.println("after swap: " + i + " " + Arrays.toString(arr));

                // 注意这里的加1，相当于堆顶元素出栈
                maxHeapify(0, i - 1);

                System.out.println("sort: " + Arrays.toString(arr));
            }
        }


        if ("desc".equals(orderBy)){
            // 把整个数组构造成小顶堆，构造完成后第一个元素已经是最小值
            for (int i = firstNodeIndex; i >= 0; i--) {
                minHeapify(i, len-1);
            }

            // 第一个元素已经是最小值，与最后一个值交换，重新构建小顶堆
            for (int i = len - 1; i > 0; i--) {
                QuickSort.swap(arr, 0, i);

                // 注意这里的减1，相当于堆顶元素出栈
                minHeapify(0, i - 1);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {4, 5, 3, 5, 6, 7, 1, 6, 6};
        //System.out.println(Arrays.toString(arr));
        int[] sortArr = new HeapSort(arr, arr.length).heapSort("asc");
        System.out.println("sorted: " + Arrays.toString(sortArr));

        sortArr = new HeapSort(arr, arr.length).heapSort("desc");
        System.out.println(Arrays.toString(sortArr));
    }
}
