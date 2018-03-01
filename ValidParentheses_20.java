package com.cxj.leetcode;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        int i=0,j=s.length();
        if(s.length()%2==1)
            return false;
        else{
            while(i<=s.length()/2){
                if(s.indexOf(i)==s.indexOf(j)){
                    i++;
                    j--;
                }
                else
                    return false;

            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses_20 vp = new ValidParentheses_20();
        boolean result = vp.isValid("({})");
        System.out.println(result);
    }
}