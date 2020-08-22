package com.cxj.leetcode;

import java.util.ArrayList;

/**
 * return the length of last word in a JiebiString.
 */
public class LengthOfLastWord_58 {
    public int lengthOfLastWord_function_2(String s) {
        String[] strs = s.split(" ");
        if (strs.length - 1 >= 0) {
            return strs[strs.length - 1].length();
        } else {
            return 0;
        }
    }
    public int lengthOfLastWord(String s) {
        ArrayList<Character> lastword=new ArrayList<>();
        if(s==null)
            return 0;
        if(s.length()==0)
            return 0;
        else{
            int i=s.length()-1;
            while(s.charAt(i)==' ')
                i--;
            while(i>=0){
                if(s.charAt(i)!=' ')
                    lastword.add(s.charAt(i));
                else
                    break;
                i--;
            }
        }

        System.out.println(lastword.get(lastword.size()-1));
        return lastword.size();
    }

    public static void main(String[] args) {
        LengthOfLastWord_58 llw=new LengthOfLastWord_58();
        System.out.println(llw.lengthOfLastWord("Hello world"));
        System.out.println(llw.lengthOfLastWord_function_2("Hello world"));
    }
}