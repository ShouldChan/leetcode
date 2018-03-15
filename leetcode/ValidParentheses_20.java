package com.cxj.leetcode;

import java.util.Stack;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }else{
                if(stack.empty())
                    return false;
                char tmp=stack.peek();
                if((tmp=='('&&s.charAt(i)==')')||(tmp=='['&&s.charAt(i)==']')||(tmp=='{'&&s.charAt(i)=='}')){
                    stack.pop();
                }
            }

        }
        if(stack.empty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        ValidParentheses_20 vp = new ValidParentheses_20();
        boolean result = vp.isValid("(");
        System.out.println(result);
    }
}