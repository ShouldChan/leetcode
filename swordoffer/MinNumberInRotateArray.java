package com.cxj.swordoffer;

/**
 * ShouldChan
 * 旋转数组最小数字
 */

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {

        if (array == null || array.length <= 0)
            System.out.println("JiebiArray is empty.");
        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            //index1 index2 indexMid指向值都一样 则顺序查找;
            if (array[index1] == array[index2] && array[indexMid] == array[index1]) {
                return minInOrder(array, index1, index2);
            }
            //34512  通过二分查找的思想缩小范围
            if (array[index1] <= array[indexMid])
                index1 = indexMid;
            else {
                index2 = indexMid;
            }
        }

        return array[indexMid];
    }

    //在序列中找出最小值
    public int minInOrder(int[] array, int index1, int index2) {
        int min = array[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (min >= array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinNumberInRotateArray mmm = new MinNumberInRotateArray();
        int[] array = {3, 4, 5, 6, 8, 15, 1, 2};
        int result = mmm.minNumberInRotateArray(array);
        System.out.println(result);
    }
}