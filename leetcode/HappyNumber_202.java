package com.cxj.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber_202 {
    public boolean isHappy(int n) {
        Set<Integer> inloop = new HashSet<>();
        int remain = 0, sum = 0;
        while (inloop.add(n)) {
            sum = 0;
            while (n > 0) {
                remain = n % 10;
                sum += remain * remain;
                n /= 10;
            }
            if (sum == 1)
                return true;
            else
                n = sum;
        }

        return false;
    }

    public static void main(String[] args) {
        HappyNumber_202 hn = new HappyNumber_202();
        System.out.println(hn.isHappy(19));
    }
}