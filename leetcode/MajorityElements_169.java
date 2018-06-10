package com.cxj.leetcode;

import java.util.*;

public class MajorityElements_169 {
    public int majorityElement(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
            list.add(nums[i]);
        }

        int count=0;
        int major=0;
        int num=0;

        for(int i=0;i<set.toArray().length;i++){
            count=Collections.frequency(list, set.toArray()[i]);
//            System.out.println(set.toArray()[i]);
            if(major<count){
                major=count;
//                System.out.println(set.toArray()[i]);
                String str=set.toArray()[i].toString();
                num=Integer.parseInt(str);
            }
        }

        return num;
    }

    public static void main(String[] args) {
        MajorityElements_169 ms=new MajorityElements_169();
        int[] nums={2,2,1,1,1,2,2};
        System.out.println(ms.majorityElement(nums));
    }
}