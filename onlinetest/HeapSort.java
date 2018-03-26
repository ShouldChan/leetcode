package com.cxj.onlinetest;

import java.util.Arrays;

public class HeapSort {
    public void heapSort(int[] array) {
        int len = array.length;

        for (int i = 0; i < len - 1; i++) {
            buildMaxHeap(array, len - 1 - i);
            swap(array, 0, len - 1 - i);
        }

    }

    public void buildMaxHeap(int[] array, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;
            while (2 * k + 1 <= lastIndex) {
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex)
                    if (array[biggerIndex] < array[biggerIndex + 1])
                        biggerIndex++;
                if (array[k] < array[biggerIndex]) {
                    swap(array, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }

            }
        }
    }

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        int[] test = {87, 45, 78, 32, 17, 65, 53, 9};
        HeapSort hs = new HeapSort();
        hs.heapSort(test);
        System.out.println(Arrays.toString(test));
    }
}