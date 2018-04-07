package com.cxj.swordoffer;

/**
 * 问题描述：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 思路：1的二进制只有最后一位为1,他左移一位后就变成只有第二位为1,以此每次左移都保证当前位为1
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((n & flag) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }


    public static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1 nof = new NumberOf1();
        System.out.println(nof.NumberOf1(-10));
        System.out.println(numberOf1(10));
    }
}