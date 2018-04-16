package com.cxj.onlinetest;

import java.util.Arrays;

/**
 * 给出一个数N，判断0-N中有多少个数的二进制是回文数
 */

public class Weizhong_1 {
    //    优化方法
    public static String toBin(int num) {
        String result = "";
        char[] chs = {'0', '1'};
        char[] arr = new char[32];
        int index = arr.length;
        while (num != 0) {
            int temp = num & 1;
            arr[--index] = chs[temp];
            num = num >>> 1;
        }
//        System.out.println(Arrays.toString(arr));
        return toString(arr, index);
    }

    //转String 方法
    public static String toString(char[] arr, int index) {
        String temp = "";
        for (int i = index; i < arr.length; i++) {
            temp += arr[i];
        }
        return temp;
    }

    public static String toBinary(int num) {
        int[] binArray = new int[32];
        int flag = 1;

        if (num >= 0) {
            for (int i = 31; i >= 0; i--) {
                if ((num & flag) == 1)
                    binArray[i] = 1;
                num = num >>> 1;
            }
        } else {
            num = 0 - num;
            for (int i = 31; i >= 0; i--) {
                if ((num & flag) == 1)
                    binArray[i] = 0;
                else
                    binArray[i] = 1;
                num = num >>> 1;
            }

//            反码+1
            int add = 1;
            for (int i = 31; i >= 0; i--) {
                if (binArray[i] + add == 2) {
                    binArray[i] = 0;
                } else {
                    binArray[i] = 1;
                    add = 0;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(binArray));
        String result = "";
        int i = 0;
        for (; i < binArray.length; i++) {
            if (binArray[i] == 1)
                break;
        }
        while (i < binArray.length) {
            result += binArray[i];
            i++;
        }
        System.out.println(result);

        return result;
    }

    public static boolean isPalin(String str) {
        int length = str.length();
        int begin = 0;
        int end = length - 1;
        while (begin < end) {
            if (str.charAt(begin++) != str.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(toBinary(26));
//        System.out.println(isPalin(toBinary(26)));
        int n=26;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPalin(toBin(i))) {
                count++;
            }
        }
        System.out.println(count);
//        System.out.println(toBin(26));
    }
}