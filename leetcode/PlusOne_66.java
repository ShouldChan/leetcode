package com.cxj.leetcode;

import java.util.Arrays;

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        long temp=0;

        for(int i=0;i<len;i++){
            temp+=Math.pow(10,len-i-1)*digits[i];
        }
//        System.out.println(temp);
        temp+=1;
        System.out.println(temp);
        if(getWeishu(temp)==len){
            int[] result=new int[len];
            for(int i=0;i<len;i++){
//            System.out.println(temp);
                long y=(long)(temp/(Math.pow(10,len-i-1)));
                System.out.println(y);
                int x=(int)(y);
                result[i]=x;
//            System.out.println("x"+x);
//            System.out.println(temp);
                temp=temp-(int)Math.pow(10,len-i-1)*x;
//            System.out.println(temp);
            }
            return result;
        }else{
            int[] result=new int[len+1];
            result[0]=1;
            for(int i=1;i<len+1;i++){
                result[i]=0;
            }
            return result;
        }

//        return null;
    }

    public int getWeishu(long num){
        int count=0;
        while(num>0){
            num/=10;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int len=sc.nextInt();
//        int[] digits=new int[len];
//        for(int i=0;i<len;i++){
//            digits[i]=sc.nextInt();
//        }
        int[] digits={9,8,7,6,5,4,3,2,1,0};
        PlusOne_66 po=new PlusOne_66();
        int[] result=po.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}