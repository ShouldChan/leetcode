package com.cxj.swordoffer;

/**
 * 问题描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (a > b) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        String result = "";
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i] + "";
        }
        return result;
    }

    public static void main(String[] args) {
        PrintMinNumber pmn = new PrintMinNumber();
        int[] numbers = {32, 3, 321};
        String result = pmn.PrintMinNumber(numbers);
        System.out.println(result);
    }
}