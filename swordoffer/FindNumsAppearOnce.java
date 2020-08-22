package com.cxj.swordoffer;

/**
 * 问题描述：
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 思路：
 * *  数组只有一个数字出现一次的话，数组中所有元素异或结果就为那个出现一次的元素。 这倒题的话就把他分成两组，
 * 每组只有一个出现一次的数字，其余都为两次
 * 1. 依次对所有数组异或，因为数组里所有元素只出现一次的只有两个， 其余都出现两次，所以最后的异或结果不为0的
 * 2. 找到异或结果中第一个为1的位置， 第index位。以index==1为分组依据
 * <p>
 * * !!!为什么index==1就能作为分类依据呢？!!!
 * 我自己的理解：因为全数组数字异或的结果就等同于两个只出现一次的数字a，b异或的结果，所以a和b二进制中必有1,找到第一次出现1的index做标准
 * 假设a的第index位为1,出现两次第index位都为1的数字和a分在一起，构成一组就能让其异或后只为a了，同理，b也是这样。
 * 如果其余出现两次的数字二进制第index位都为1的话，这些数字和a全部分到一个组，而另一个组只有数字b。这是极端情况。
 * 所以能保证第index==1可以作为分组标准。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int length = array.length;
        if (length < 2)
            System.out.println("Less than one number in the JiebiArray");

        if (length == 2) {
            if (array[0] != array[1]) {
                num1[0] = array[0];
                num2[0] = array[1];
            } else {
                System.out.println("Two same numbers in the JiebiArray");
            }

        }

        int result = 0;

        for (int i = 0; i < length; i++) {
            result ^= array[i];
        }
        int index = findFirst1(result);

        for (int i = 0; i < length; i++) {
            if (isBit1(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
        System.out.println(num1[0] + "\t" + num2[0]);
    }

    //    找到全数组元素异或结果中第一个1的index
    public int findFirst1(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
            num = num >> 1;
            index++;
        }
        return index;
    }

    //    判断第index位是否为1
    public boolean isBit1(int num, int index) {
        return ((num >> index) & 1) == 1;
    }

    public static void main(String[] args) {
        FindNumsAppearOnce fn = new FindNumsAppearOnce();
        int[] array = {2, 3, 4, 6, 3, 2, 5, 5, 6, 8};
        int num1[] = new int[1];
        int num2[] = new int[1];
        fn.FindNumsAppearOnce(array, num1, num2);
    }
}