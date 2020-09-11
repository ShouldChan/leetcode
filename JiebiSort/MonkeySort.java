package JiebiSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/9/11
 * @description Bogo Sort
 */
public class MonkeySort {
    public boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i])
                return false;
        }
        return true;
    }

    public void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public void monkeySort(int[] array) {
        int count = 0;
        Random random = new Random();
        while (!isSorted(array)) {
            for (int i = 0; i < array.length - 1; i++) {
                count++;
                //数组有多少个元素，一趟就对这些元素进行n次交换 直到排成有序
                int t = random.nextInt(array.length - i) + i;
                swap(array, i, t);
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        MonkeySort ms = new MonkeySort();
        int[] array = {13234, 12, 767, 3, 45, 3278};
        ms.monkeySort(array);
        System.out.println(Arrays.toString(array));
    }
}
