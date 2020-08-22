package JiebiSort;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/10
 * @description
 */
public class BubbleSort {
    /**
     * 时间复杂度O（n^2）
     * 平均 最坏都是 O（n^2）
     * 最好时间复杂度O（n）：比较n-1次 移动0次 最优情况得加上flag去判断 表示有无交换的可能 若一轮下来没有发生交换就直接跳出循环。
     * 空间复杂度O（n）
     * @param array
     * @return
     */
    public int[] bubbleSort(int[] array) {
        //array.length-1是因为 最后一个元素不需要排列 之后会有j+1把最后一个元素进行比较 不然就越界了
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            //每轮都会排好一个元素 所以规律一下 就是只需要检查array.length-1-i个元素
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
//                    flag = true;
                }
            }
            //若一轮下来，没有发生交换 说明都排好了 就直接跳出循环
            if (!flag)
                break;
        }
        return array;
    }

    public void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] array = {3, 4, 1, 2, 6};
//        bs.swap(array,0,1);
//        System.out.println(array[0]+"\t"+array[1]);
        bs.bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
