package com.cxj.onlinetest;

import java.util.Arrays;
import java.util.Scanner;

public class Keda_1 {

    public static int[] wherePrime(int max) {

        int[] primeArray = new int[max];
        int index = 0;
        for (int i = 2; index < max; i++) {
            boolean isprime = true;
            for (int j = 0; j < index; j++) {
                if (i % primeArray[j] == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime)
                primeArray[index++] = i;

        }
        System.out.println(Arrays.toString(primeArray));
        return primeArray;
    }

    public static int selectBiggest(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int[] nums = new int[q];

        for (int i = 0; i < q; i++) {
            nums[i] = sc.nextInt();
        }
        int max = selectBiggest(nums);

        int[] primeArray = wherePrime(max);
        for (int i = 0; i < q; i++) {
            System.out.println(primeArray[nums[i] - 1]);
        }
    }
}