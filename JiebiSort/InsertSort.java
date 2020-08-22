package JiebiSort;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/11
 * @description
 */
public class InsertSort {
    /**
     * 平均时间复杂度O（n^2）
     * 最坏时间复杂度O（n^2）
     * 最好时间复杂度O（n）
     * 空间复杂度O（n）
     *
     * @param array
     * @return
     */
    public int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j;
//            System.out.println("i:"+i);
            for (j = i - 1; j >= 0; j--) {
//                System.out.println("j:"+j);
                //发现新来的牌比之前的牌最大的那个小 就把之前最大的牌往后放。
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
//                    System.out.println("swqp");
                }
                //找到新牌比之前排好的牌大的那个位置就跳出循环。
                else
                    break;
            }
            //跳出循环后 j指向的位置是之前已经排好的最后一个元素 所以j+1的位置应该插入新进来的那张牌
            array[j + 1] = tmp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 3, 9, 7};
        InsertSort is = new InsertSort();
        is.insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
