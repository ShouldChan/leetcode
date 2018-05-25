package com.cxj.leetcode;

import java.util.Arrays;

/**
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while (j >= 0)
            nums1[k--] = nums2[j--];
    }

    public static void main(String[] args) {
        MergeSortedArray_88 msa = new MergeSortedArray_88();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int n = nums2.length;
        int m = nums1.length - n;
        msa.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}