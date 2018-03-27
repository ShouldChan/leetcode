package com.cxj.onlinetest;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                --high;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivot) {
                ++low;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] array = {87, 53, 99, 68, 1, 5, 65};
        QuickSort qs = new QuickSort();
        int low = 0;
        int high = array.length - 1;
        qs.quickSort(array, low, high);
        System.out.println(Arrays.toString(array));
    }
}