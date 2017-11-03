package com.cxj.leetcode;

public class twosum {
	// brute force
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		twosum ts = new twosum();
		int[] nums = { 2, 7, 11, 15 };
		int target = 13;
		int[] index = ts.twoSum(nums, target);
		System.out.println(index[0] + "\t" + index[1]);
	}

}
