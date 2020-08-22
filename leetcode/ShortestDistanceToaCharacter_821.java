package com.cxj.leetcode;

import java.util.Arrays;

/**
 * Given a JiebiString S and a character C, return an JiebiArray of integers representing the shortest distance from the character C in the JiebiString.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * <p>
 * <p>
 * Note:
 * <p>
 * S JiebiString length is in [1, 10000].
 * C is a single character, and guaranteed to be in JiebiString S.
 * All letters in S and C are lowercase.
 */
public class ShortestDistanceToaCharacter_821 {
    /**
     * function 1
     * brute force  time complexity:O(n^2)
     *
     * @param S
     * @param C
     * @return
     */
    public int[] shortestToChar(String S, char C) {

        char[] charArray = S.toCharArray();
        int len = charArray.length;
        int[] shortest = new int[len];
        for (int i = 0; i < len; i++) {
            shortest[i] = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if (charArray[j] == C && Math.abs(j - i) < shortest[i]) {
                    shortest[i] = Math.abs(j - i);
                }
            }
        }
        return shortest;
    }

    /**
     * function 2
     * 思想就是
     * 用pre记录S中为C字符的位置
     * （1）从左到右遍历一遍，那么值就为i-pre
     * 为了保证最后取最小，所以pre没有指向等于C字符的位置之前，i-pre要尽可能的大，
     * 所以pre要初始化为-Integer.MAX+len（|MAX|<|MIN|）
     * （2）从右到左遍历一遍，那么值就为pre-i
     * pre要初始化为最大
     * 这次遍历需要将第一次遍历后得到的数组对比取最小作为最后的值。
     * 遍历了两遍S
     * time complexity: O(n)
     *
     * @param S
     * @param C
     * @return
     */
    public int[] function_2(String S, char C) {
        int len = S.length();
        int[] shortest = new int[len];
        int pre = -Integer.MAX_VALUE + len;  //pre指向每轮S中等于C字符的下标
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C) pre = i;
            shortest[i] = i - pre;
        }
        pre = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (S.charAt(i) == C) pre = i;
            shortest[i] = Math.min(pre - i, shortest[i]);
        }
        return shortest;
    }

    public static void main(String[] args) {
        ShortestDistanceToaCharacter_821 sdtc = new ShortestDistanceToaCharacter_821();
        String S = "loveleetcodefucks";
        char C = 'e';
        System.out.println(Arrays.toString(sdtc.shortestToChar(S, C)));
        System.out.println(Arrays.toString(sdtc.function_2(S, C)));
    }
}