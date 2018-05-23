package com.cxj.leetcode;

/**
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int current_max = nums[0];
        int final_max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current_max >= 0)
                current_max += nums[i];
            else
                current_max = nums[i];
            if (current_max > final_max)
                final_max = current_max;
        }
        return final_max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        MaximumSubarray_53 ms = new MaximumSubarray_53();
        System.out.println(ms.maxSubArray(nums));
    }
}