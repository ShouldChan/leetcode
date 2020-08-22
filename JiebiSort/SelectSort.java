package JiebiSort;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/11
 * @description
 */
public class SelectSort {

    /**
     * 平均时间复杂度O（n^2）
     * 最坏时间复杂度O（n^2）
     * 最好时间复杂度O（n） 设置了比较min>0 若没有发现比array[0]小的，就只比较了n-1次 没有交换
     * 空间复杂度O（n） 每次都有一个min变量
     * @param array
     * @return
     */
    public int[] selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            //交换每轮选出的最值，这样把最值放在前面，接着后面没有排好的继续选出最值。
            //最好情况，一轮下来没有找到比array[0]还小的 所以就用这个判断直接结束 无需交换。
            if (min > i)
                swap(array, min, i);
        }
        return array;
    }

    public void swap(int[] array, int x, int y) {
        int tmp = array[y];
        array[y] = array[x];
        array[x] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 1, 6, 7};
        SelectSort ss = new SelectSort();
        ss.selectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
