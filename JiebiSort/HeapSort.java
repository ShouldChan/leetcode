package JiebiSort;

import java.util.Arrays;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/9/2
 * @description
 */
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
            adjustDownToUp(array, i, lastIndex);
        }
    }

    public void adjustDownToUp(int[] array, int k, int lastIndex) {
        while (2 * k + 1 < lastIndex) {
            int biggerIndex = 2 * k + 1;
            if (biggerIndex < lastIndex) {
                if (array[biggerIndex] < array[biggerIndex + 1])
                    biggerIndex++;
            }
            if (array[k] < array[biggerIndex]) {
                swap(array, k, biggerIndex);
                k = biggerIndex;
            } else
                break;
        }
    }

    public void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] array = {3, 6, 7, 13, 1, 3};
        hs.heapSort(array);
        System.out.print(Arrays.toString(array));
    }
}
