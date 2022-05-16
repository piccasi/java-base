package algorithm.sort;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: QuickSort
 * @Since: 1.0
 * @Version: v1.0
 * @Date: 2022/5/7 9:40 上午
 * @Author: piccasi@163.com
 * @Description: 快速排序
 **/

public class QuickSort {

    public static int quickSort(int[] arr, int start, int end, String orderBy) {
        int pivotIndex = -1;
        if(start < end) {
            pivotIndex = pivotIndexLookUp(arr, start, end, orderBy);

            //左子序列
            quickSort(arr, start, pivotIndex - 1, orderBy);
            //右子序列
            quickSort(arr, pivotIndex + 1, end, orderBy);
        }
        return pivotIndex;
    }

    /**
     * 寻找pivot是递归实现快排的关键，pivot来自集合中任意一个元素，根据排序方向把集合中元素调整到pivot前面或者后面，
     * 最后把pivot放在集合中正确的位置，返回pivot的索引
     * @param arr
     * @param start
     * @param end
     * @param orderBy
     * @return pivot的位置
     */
    public static int pivotIndexLookUp(int [] arr, int start, int end, String orderBy){
        //选取第一个元素作为pivot
        int pivot = arr[start];
        int pivotIndex = start;
        //offset是用来寻找pivot的正确位置，因为选取的是第一个，第一个元素不用比较，所以从第二个开始
        int offset = pivotIndex + 1;

        for (int i = offset; i <= end; i++) {
            if (compare(arr[i], pivot, orderBy)) {
                swap(arr, i, offset);
                offset++;
            }
        }

        //这次交换很关键，经过上面的循环后offset前面的元素都比pivot小，offset当前指向的元素则大于或等于pivot，所以把pivot放在offset-1的位置就是正确的位置
        swap(arr, pivotIndex, offset - 1);
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

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArr(int arr[]) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if(i != arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");

        System.out.println(sb);
    }

    public static void main(String[] args) {
        int[] arr = {5,3,1,8,9,11,4,2,11,13,15,-1};
        quickSort(arr, 0, arr.length-1, "asc");
        printArr(arr);
    }
}
