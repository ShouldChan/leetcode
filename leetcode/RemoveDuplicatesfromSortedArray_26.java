package com.cxj.leetcode;

public class RemoveDuplicatesfromSortedArray_26 {
    /**
     * function 1
     * 因为是排好的数组
     * 思想：使用两个指针 一个指针j遍历数组 一个指针i起一个集合的作用记录出现过的值
     * 如果nums[j]!=nums[i]就执行记录值的操作
     * 所以最后的没有重复的数组长度就是i指向的下标值+1
     * time complexity: O(n)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }

        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray_26 rd = new RemoveDuplicatesfromSortedArray_26();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(rd.removeDuplicates(nums));
    }
}