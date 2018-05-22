package com.cxj.leetcode;

/**
 * input: haystack="hello",needle="ll"
 * output: return the first occurrence of needle in haystack 2
 * if not, return -1
 */
public class ImplementStr_28 {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;  //找到相同的时候 保持i不动j动
                if (i + j == haystack.length()) return -1; //i+j指到最后还没找到就返回-1
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ImplementStr_28 is=new ImplementStr_28();
        System.out.println(is.strStr("hello","lxl"));
    }
}