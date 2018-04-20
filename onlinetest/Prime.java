package com.cxj.onlinetest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//求n以内的素数的个数
//第一快： 通过实验得出效率最高的是第二层循环使用2-sqrt(i)的最快
//第二快： 对每个数对比他小的质数看能否被整除 因为每个质数都是由若干个素数相乘组成的
//第三快： n方复杂度的遍历呀

public class Prime {
    //    function1
    public static List<Integer> prime_1(int n) {
        List<Integer> primeArray = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeArray.add(i);
            }
        }
        Iterator it = primeArray.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
        System.out.println(primeArray.size());
        return primeArray;
    }

    //    function2
    public static List<Integer> prime_2(int n) {
        List<Integer> primeArray = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {//重点 <=
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeArray.add(i);
            }
        }
        System.out.println(primeArray.size());
        return primeArray;
    }

    //    function3
    public static List<Integer> prime_3(int n) {
        List<Integer> primeArray = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 0; j < primeArray.size(); j++) {
                if (i % primeArray.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeArray.add(i);
            }
        }
        System.out.println(primeArray.size());
        return primeArray;
    }

    //    求截止到排行第k个素数的数组 g1
    public static int[] prime_4(int k) {
        int[] primeArray = new int[k];
        int index = 0;
        for (int i = 2; index < k; i++) {
            boolean isPrime = true;
            for (int j = 0; j < index; j++) {
                if (i % primeArray[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                primeArray[index++] = i;
        }
        System.out.println(primeArray.length);
        return primeArray;
    }

    //g2 -----优化
    public static int[] prime_5(int k) {
        int[] primeArray = new int[k];
        int index = 0;
        for (int i = 2; index < k; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                primeArray[index++] = i;
        }
        System.out.println(primeArray.length);
        return primeArray;
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        List<Integer> list1 = prime_1(100000);
//        System.out.println(list1.size());
        long t2 = System.currentTimeMillis();
        long delta_t1 = t2 - t1;

        System.out.println(delta_t1);

        t1 = System.currentTimeMillis();
        List<Integer> list2 = prime_2(100000);
//        System.out.println(list2.size());
        t2 = System.currentTimeMillis();
        long delta_t2 = t2 - t1;

        System.out.println(delta_t2);


        t1 = System.currentTimeMillis();
        List<Integer> list3 = prime_3(100000);
//        System.out.println(list3.size());
        t2 = System.currentTimeMillis();
        long delta_t3 = t2 - t1;
        System.out.println(delta_t3);

        t1 = System.currentTimeMillis();
        int[] array1 = prime_4(100000);
//        System.out.println(list3.size());
        t2 = System.currentTimeMillis();
        long delta_t4 = t2 - t1;
        System.out.println(delta_t4);

        t1 = System.currentTimeMillis();
        int[] array2 = prime_5(100000);
//        System.out.println(list3.size());
        t2 = System.currentTimeMillis();
        long delta_t5 = t2 - t1;
        System.out.println(delta_t5);
    }
}