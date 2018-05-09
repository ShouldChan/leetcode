package com.cxj.onlinetest;

import java.util.Arrays;

public class Kugou {
    public static void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int binarySearch(int[] nums, int key) {
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == key)
                return mid;
            else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {23, 45, 1, 3, 64, 2, -9, 34};
        System.out.println(binarySearch(nums, 34));
    }

}