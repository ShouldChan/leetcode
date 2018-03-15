package com.cxj.leetcode;

/*
罗马数字规则：
1. 重复数次：一个罗马数字重复几次，就表示这个数的几倍。
2. 右加左减：在一个较大的罗马数字的右边记上一个较小的罗马数字，
表示大数字加小数字。在一个较大的数字的左边记上一个较小的罗
马数字，表示大数字减小数字。但是，左减不能跨越等级。
3. 加线乘千：在一个罗马数字的上方加上一条横线，表示将这个数字
乘以1000，即是原数的1000倍。同理，如果上方有两条横线，
即是原数的1000000倍。
组数规则　有几条须注意掌握；
(1)基本数字Ⅰ、X 、C 中的任何一个，自身连用构成数目，或者放在大数的右边连用构成数目，都不能超过三个；放在大数的左边只能用一个。
(2)不能把基本数字V 、L 、D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目；放在大数的右边采用相加的方式构成数目，只能使用一个。
(3)V 和X 左边的小数字只能用Ⅰ。
(4)L 和C 左边的小数字只能用X。
(5)D 和M 左边的小数字只能用C 。
(6)在数字上加一横表示这个数字的1000倍。
 */
public class RomanToInteger_13 {
    public int romanToInt(String s) {
        int len = s.length();
        int sum = 0;

        for (int i = 0; i < len; i++) {
            //V 和X 左边的小数字只能用Ⅰ
            if (s.charAt(i) == "I".charAt(0)) {
                if (i != len - 1 && (s.charAt(i + 1) == "V".charAt(0) || s.charAt(i + 1) == "X".charAt(0))) {
                    sum--;
                } else {
                    sum++;
                }
            }

            if (s.charAt(i) == "V".charAt(0)) {
                sum += 5;
            }
            //L 和C 左边的小数字只能用X
            if (s.charAt(i) == "X".charAt(0)) {
                if (i != len - 1 && (s.charAt(i + 1) == "C".charAt(0) || s.charAt(i + 1) == "L".charAt(0))) {
                    sum -= 10;
                } else {
                    sum += 10;
                }
            }

            if (s.charAt(i) == "L".charAt(0)) {
                sum += 50;
            }
            //D 和M 左边的小数字只能用C
            if (s.charAt(i) == "C".charAt(0)) {
                if (i != len - 1 && (s.charAt(i + 1) == "D".charAt(0) || s.charAt(i + 1) == "M".charAt(0))) {
                    sum -= 100;
                } else {
                    sum += 100;
                }
            }

            if (s.charAt(i) == "D".charAt(0)) {
                sum += 500;
            }

            if (s.charAt(i) == "M".charAt(0)) {
                sum += 1000;
            }


        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger_13 rti = new RomanToInteger_13();
        Integer result = rti.romanToInt("XCIX");
        System.out.println(result);
    }
}