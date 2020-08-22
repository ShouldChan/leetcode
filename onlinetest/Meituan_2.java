package com.cxj.onlinetest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 问题：求一组由0-9组成的字符串中，不能用字符串中字符表示的最小的整数
 * 解法：
 * 1）1-9不全有
 * 最小的整数为没有的那个字符表示的个位数数字
 * 2）1-9全都有，但没有0
 * 则为（10）
 * 3）1-9全都有，并且有0
 * nx表示个数最少的数字，n0表示0的个数
 * 1.当nx>n0，如1122334455667788990，x为1, 最小整数则为（1）（0）（0）
 * 2.当nx<=n0，如1112234567890,x为3，nx为1,最小整数为（33）
 */

public class Meituan_2 {
    //    use a 2d-JiebiArray to save everyNum's counts
    public static int[][] countNum(String str) {
//        change String into int[]

        int[] array = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            array[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        System.out.println(Arrays.toString(array));
        int[][] countNumArray = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
                , {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        for (int i = 0; i < array.length; i++) {
            countNumArray[1][array[i]]++;
        }

        System.out.println(Arrays.toString(countNumArray[1]));

        return countNumArray;
    }

    public static Map<Integer, Boolean> isOne2NineAllHave(int[][] countNumArray) {
        Map<Integer, Boolean> map = new HashMap<>();
        boolean flag = true;
        int smallestNum = 1;
        for (int i = 1; i < countNumArray[1].length; i++) {
            if (countNumArray[1][i] == 0) {
                flag = false;
                smallestNum = i;
                map.put(smallestNum, flag);
                break;
            }

        }

        return map;
    }

    public static Map<Integer, Integer> shortestNum(int[][] countNumArray) {
        Map<Integer, Integer> shortestPair = new HashMap<>();
        int min_nx = countNumArray[1][1];
        int x = 1;
        for (int i = 1; i < countNumArray[1].length; i++) {
            if (countNumArray[1][i] < min_nx) {
                min_nx = countNumArray[1][i];
                x = i;
            }
        }
        shortestPair.put(min_nx, x);
        return shortestPair;
    }

    public int findSmallestNum(String str) {
        int[][] countNumArray = countNum(str);
        int smallestNum = 0;
        Map<Integer, Boolean> map = isOne2NineAllHave(countNumArray);
        Map<Integer, Integer> shortestPair = shortestNum(countNumArray);

        if (map.isEmpty()) {//condition 2 3
            if (countNumArray[1][0] == 0) {//condition 2
                return 10;
            } else {//condition 3
                int nx = 1;
                int x = 1;
                for (Map.Entry<Integer, Integer> entry : shortestPair.entrySet()) {
                    nx = entry.getKey();
                    x = entry.getValue();
                }
                int n0 = countNumArray[1][0];
//                System.out.println("n0" + n0);
//                System.out.println("nx" + nx);
                if (nx > n0) {
                    smallestNum = (int) Math.pow(10, n0 + 1);
                    return smallestNum;
                } else {
                    for (int k = 0; k < nx + 1; k++) {
                        smallestNum += x * Math.pow(10, k);
                    }
                    return smallestNum;
                }
            }

        } else {//condition 1
            int num = 1;
            for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
                num = entry.getKey();
            }
            smallestNum = num;
        }
        return smallestNum;
    }

    public static void main(String[] args) {
        Meituan_2 mt = new Meituan_2();
        String str = "111222334445556667778889990000";
        int smallestNum = mt.findSmallestNum(str);
        System.out.println(smallestNum);
    }
}