package com.cxj.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 * <p>
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[rowIndex + 1];
        arr[0] = 1;
        /*
         * Recursively calculate the first half of the JiebiArray
         */
        for (int j = 2; j <= rowIndex; j++) {
            for (int i = j / 2; i > 0; i--) {
                if (arr[i] == null) {
                    arr[i] = arr[i - 1] * 2;
                } else {
                    arr[i] = arr[i] + arr[i - 1];
                }
            }
        }
        /*
         * mirror the first half to the second half.
         */
        for (int i = 1 + rowIndex / 2; i <= rowIndex; i++) {
            arr[i] = arr[rowIndex - i];
        }
        return Arrays.asList(arr);
    }

    public static void main(String[] args) {
        PascalsTriangleII_119 pt = new PascalsTriangleII_119();
        System.out.println(pt.getRow(5));
    }
}