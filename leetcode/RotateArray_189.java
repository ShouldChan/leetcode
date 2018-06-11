package com.cxj.leetcode;

import java.util.Arrays;

public class RotateArray_189 {
    /**
     * time complexity: O(n)
     * space complexity: O(n)
     * 抓住余数的特性
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    /**
     * time limited
     *
     * @param nums
     * @param k
     */
//    public void rotate(int[] nums, int k) {
//        for (int i = 0; i < k; i++) {
//            reverse(nums);
//        }
//    }
//
//    public void reverse(int[] nums) {
//        int temp = nums[nums.length - 1];
//        for (int i = nums.length - 2; i >= 0; i--) {
//            nums[i + 1] = nums[i];
//        }
//        nums[0] = temp;
//    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        RotateArray_189 ra = new RotateArray_189();
        ra.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}