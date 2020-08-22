package JiebiSort;

import javax.swing.*;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/11
 * @description
 */
public class QuickSort {
    public int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotpos = partition(array, low, high);
            quickSort(array, low, pivotpos - 1);
            quickSort(array, pivotpos + 1, high);
        }
        return array;
    }

    public int partition(int[] array, int low, int high) {
        int pivot = array[low];
        System.out.println("基准元素:\t"+pivot);
        while (low < high) {
            while (low < high && array[high] >= pivot){
                --high;
            }
            array[low] = array[high];
            System.out.println("low:\t"+low+"\thigh:\t"+high);
            print(array);
            while (low < high && array[low] <= pivot){
                ++low;
            }
            array[high] = array[low];
            print(array);
        }
        array[low] = pivot;
        System.out.println("划分坐标:\t"+low);
        return low;
    }

    public void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] array = {5, 2, 3, 9, 7};
        qs.quickSort(array, 0, array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}