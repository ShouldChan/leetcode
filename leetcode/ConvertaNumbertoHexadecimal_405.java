package com.cxj.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 问题描述：
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * <p>
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s.
 * If the number is zero, it is represented by a single zero character '0'; otherwise,
 * the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 26
 * <p>
 * Output:
 * "1a"
 * Example 2:
 * <p>
 * Input:
 * -1
 * <p>
 * Output:
 * "ffffffff"
 */
public class ConvertaNumbertoHexadecimal_405 {
    public String toHex(int num) {
        if (num == 0)
            return "0";
        int[] binArray = toBinary(num);
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "a");
        map.put(11, "b");
        map.put(12, "c");
        map.put(13, "d");
        map.put(14, "e");
        map.put(15, "f");
        int sum = 0;
        String[] hexArray = new String[8];
        for (int i = 31, j = 7; i >= 0; i -= 4, j--) {
            sum = binArray[i] * 1 + binArray[i - 1] * 2 + binArray[i - 2] * 4 + binArray[i - 3] * 8;
            if (sum > 9) {
                hexArray[j] = map.get(sum);
            } else {
                hexArray[j] = Integer.toString(sum);
            }
        }

//        System.out.println(Arrays.toString(hexArray));

        String result = "";

        int index = 0;
        for (; hexArray[index].equals("0"); index++) {
        }

        for (int i = index; i < hexArray.length; i++) {
            result += hexArray[i];
        }
        return result;
    }

    public int[] toBinary(int num) {
        int[] binArray = new int[32];
        int flag = 1;

        if (num >= 0) {
            for (int i = 31; i >= 0; i--) {
                if ((num & flag) == 1)
                    binArray[i] = 1;
                num = num >>> 1;
            }
        } else {
            num = 0 - num;
            for (int i = 31; i >= 0; i--) {
                if ((num & flag) == 1)
                    binArray[i] = 0;
                else
                    binArray[i] = 1;
                num = num >>> 1;
            }

//            反码+1
            int add = 1;
            for (int i = 31; i >= 0; i--) {
                if (binArray[i] + add == 2) {
                    binArray[i] = 0;
                } else {
                    binArray[i] = 1;
                    add = 0;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(binArray));
        return binArray;
    }

    public static void main(String[] args) {
        ConvertaNumbertoHexadecimal_405 test405 = new ConvertaNumbertoHexadecimal_405();

        System.out.println(test405.toHex(26));

    }
}