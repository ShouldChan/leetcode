package com.cxj.leetcode;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSum_167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0, j = 0;
        for (; i < numbers.length; i++) {
            for (j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    System.out.println(i + "\t" + j);
                    return result;
                }
            }
        }

        return null;
    }

    public int[] twoSum_1ms(int[] numbers, int target) {
        int x = 0, y = numbers.length - 1;
        while (x < y) {
            //int mid=x+(y-x)/2;
            if (numbers[x] + numbers[y] == target) return new int[]{x + 1, y + 1};
            if (numbers[x] + numbers[y] > target)
                y--;
            else
                x++;
        }
        return numbers[x] + numbers[y] == target ? new int[]{x + 1, y + 1} : new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum_167 ts = new TwoSum_167();
        int[] numbers = {2, 7, 11, 15};
        ts.twoSum(numbers, 18);
        ts.twoSum(numbers, 9);
    }
}