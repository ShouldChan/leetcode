package com.cxj.leetcode;

//Write a function to find the longest common prefix string amongst an array of strings.

public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }


    public static void main(String[] args) {
        LongestCommonPrefix_14 lcp = new LongestCommonPrefix_14();
        String[] strs = {"asdcdfdgiwoej2134", "asddsdf3242", "asdfsdf2134"};
        String result = lcp.longestCommonPrefix(strs);
        System.out.println(result);
        System.out.println(strs[0].indexOf("asd"));
    }
}