package com.cxj.swordoffer;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class DuplicateArray {

    public boolean duplicate(int array[], int length, int[] duplication) {
        if (array == null) return false;

        // 判断数组是否合法（每个数都在0~n-1之间）
        for (int i = 0; i < length; i++) {
            if (array[i] < 0 || array[i] > length - 1) {
                return false;
            }
        }

        int[] hash = new int[length];
        for (int i = 0; i < length; i++) {
            hash[array[i]]++;
        }
        for (int i = 0; i < length; i++) {
            if (hash[i] > 1) {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicateArray da = new DuplicateArray();
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int length = numbers.length;
        int[] duplication = new int[1];
        da.duplicate(numbers, length, duplication);
        System.out.println(duplication[0]);
    }
}