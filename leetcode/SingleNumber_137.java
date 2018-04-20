package com.cxj.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public static void main(String[] args) {
        int[] array = {11, 11, 11, 3, 2, 2, 2, 6, 6, 6};
        System.out.println(singleNum_1(array));
        System.out.println(singleNum_2(array));
    }
}