package com.cxj.onlinetest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 通过60%测试样列
 */
public class huawei_2 {

    public boolean isIPv6(String address) {
        boolean flag = true;
        char[] charArr = address.toCharArray();
        Set<Character> set = new HashSet<Character>();
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
        set.add('A');
        set.add('B');
        set.add('C');
        set.add('D');
        set.add('E');
        set.add('F');
        set.add(':');

        if (charArr[4] == ':' && charArr[9] == ':' && charArr[14] == ':' && charArr[19] == ':' && charArr[24] == ':' && charArr[29] == ':' && charArr[34] == ':') {
            for (int i = 0; i < charArr.length; i++) {
                if (!set.contains(charArr[i]))
                    flag = false;
            }
        } else {
            flag = false;
        }

        if (flag == true)
            return true;
        else {
            return false;
        }

    }

    public String selectIpv6Tpye(String input) {
        if (isIPv6(input)) {
            String[] array = input.split(":");
            String binaryStr = "";
            for (int i = 0; i < array.length; i++) {
                binaryStr += hexString2binaryString(array[i]);
            }
//            System.out.println(binaryStr);
            char[] charArr = binaryStr.toCharArray();
            //Unspecified
            boolean flag = true;
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] != '0')
                    flag = false;
            }
            if (flag == true)
                return "Unspecified";

            //Loopback
            flag = true;
            if (charArr[charArr.length - 1] == '1') {
                for (int i = 0; i < charArr.length - 1; i++) {
                    if (charArr[i] != '0')
                        flag = false;
                }
            }
            if (flag == true)
                return "Loopback";

            //LinkLocal&&SiteLocal
            flag = true;
            for (int i = 0; i < 7; i++) {
                if (charArr[i] != '1')
                    flag = false;
            }
            if (flag == true) {
                if (charArr[7] == '0' && charArr[8] == '1' && charArr[9] == '0')
                    return "LinkLocal";
                else if (charArr[7] == '0' && charArr[8] == '1' && charArr[9] == '1')
                    return "SiteLocal";
            }
            //Multicast
            flag = true;
            for (int i = 0; i < 8; i++) {
                if (charArr[i] != '1')
                    flag = false;
            }
            if (flag == true)
                return "Multicast";
            return "GlobalUnicast";
        } else {
            return "Error";
        }
    }

    public static String hexString2binaryString(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0)
            return null;
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000"
                    + Integer.toBinaryString(Integer.parseInt(hexString
                    .substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
    }

    public static void main(String[] args) {
        huawei_2 hw = new huawei_2();
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
//        String input = "0000:0000:0000:0000:0000:0000:0000:0001";
        String result=hw.selectIpv6Tpye(input);
        System.out.println(result);

    }
}