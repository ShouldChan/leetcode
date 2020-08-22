package com.cxj.leetcode;

import java.util.*;

/**
 * 题目描述
 * 一个数组里面 只有一个数出现过一次 其他都出现三次
 */

public class SingleNumber_137 {

    //    function1  将所有的元素存入set 然后对set里的元素乘以3最后减去数组中的元素 就还剩两个（出现一次的数） 然后除以2
    public static int singleNum_1(int[] array) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
            sum += array[i];
        }

        int sum_2 = 0;
        for (int i : set) {
            sum_2 += i;
        }
        return (sum_2 * 3 - sum) / 2;
    }

    //    function2 Map统计每个数出现的个数
    public static int singleNum_2(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else
                map.put(array[i], map.get(array[i]) + 1);
        }

        Integer ikey = new Integer(1);
        int key = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (ikey.equals(entry.getValue()))
                key = entry.getKey();
        }
        return key;
    }

    //    function 3
//    使用位运算
    public static int singleNum_3(int[] array){
        int[] bits=new int[32];
        Arrays.fill(bits,0);
        //bits save 所有数第j位的1的个数
        for(int i=0;i<array.length;i++){
            for(int j=0;j<32;j++){
                bits[j] += ((array[i] >> j) & 1);
            }
        }
//      当该数组所有元素都出现三次，那么每位的统计结果都可以被3整除，通过对该数组添加任何一个数字
//        这个数的二进制的每一位加上去之后都不能被3整除。
//        所以不能被三整除的那一位就是出现一次的数字的那一位，算出每一位上不能被3整除的二进制位之和那就是这个出现一次的数
        int result=0;
        for(int j=0;j<32;j++){
            if(bits[j]%3!=0)
                result+=(1<<j);
        }
        return result;

    }


    public static void main(String[] args) {
        int[] array = {11, 11, 11, 3, 2, 2, 2, 6, 6, 6};
//        System.out.println(singleNum_1(JiebiArray));
//        System.out.println(singleNum_2(JiebiArray));
        System.out.println(singleNum_3(array));
    }


}