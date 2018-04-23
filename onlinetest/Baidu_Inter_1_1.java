package com.cxj.onlinetest;

import java.util.Arrays;

/**
 *
 */
public class Baidu_Inter_1_1 {
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pos = partition(array, low, high);
            quickSort(array, low, pos - 1);
            quickSort(array, pos + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] <= pivot)//递增递减排序只需在此改变比较符号
                --high;
            array[low] = array[high];
            while (low < high && array[low] >= pivot)//递增递减排序只需在此改变比较符号
                ++low;
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
//        第一题 快排
        int[] test = {12, 3, 66, 2, 8897, 12, 234, 547, 993, 11, -1, -87, 0, 66};
        int len = test.length;
        quickSort(test, 0, len - 1);
        System.out.println(Arrays.toString(test));


    }
}