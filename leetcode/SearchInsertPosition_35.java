package com.cxj.leetcode;

/**
 * given a sorted array and a value, insert the value to make the array sorted
 * return the position of insert.
 * input: array, value
 * output: the index of the position
 */
public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target)
                continue;
            else
                return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        SearchInsertPosition_35 sip = new SearchInsertPosition_35();
        int[] nums = {1, 3, 4, 5};
        int target = 6;
        System.out.println(sip.searchInsert(nums, target));
    }

}