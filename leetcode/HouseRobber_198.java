package com.cxj.leetcode;

public class HouseRobber_198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length > 2)
            dp[2] = nums[0] + nums[2];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[0] = nums[0];

        int i = 3;
        for (; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        if (nums.length == 1)
            return dp[0];
        else if (nums.length == 2)
            return dp[1];
        else {
            return Math.max(dp[i - 1], dp[i - 2]);
        }
    }

    public static void main(String[] args) {
        HouseRobber_198 hr = new HouseRobber_198();
        int[] nums = {0};
        System.out.println(hr.rob(nums));
    }
}