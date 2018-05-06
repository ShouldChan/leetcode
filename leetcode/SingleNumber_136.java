package com.cxj.leetcode;

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test={4,1,2,1,2};
        SingleNumber_136 sn=new SingleNumber_136();
        System.out.println(sn.singleNumber(test));
    }
}