package com.cxj.leetcode;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary_67 {
    public String addBinary(String a, String b) {
        if (a.length() == 0 && b.length() == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            sum = carry;
            //对每位进行计算
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            //既然是二进制 对二求余就得到该为上的值
            sb.append(sum % 2);
            //判断下一位要不要+1
            carry = sum / 2;
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary_67 ab = new AddBinary_67();
        System.out.println(ab.addBinary("11", "1"));
    }
}