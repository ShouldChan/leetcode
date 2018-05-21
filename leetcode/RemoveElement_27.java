package com.cxj.leetcode;

/**
 * remove val in nums return the length of the rest nums
 */
public class RemoveElement_27 {
    /**
     * function 1
     * 思想：双指针 一个指针遍历，一个指针记录值
     * 只要遍历过程中元素不为val就记录下，最后返回长度。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement_27 re = new RemoveElement_27();
        int[] nums = {3, 2, 2, 3};
        System.out.println(re.removeElement(nums, 3));
    }
}