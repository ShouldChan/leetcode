package JiebiDynamicProgramming.GreedyAlgorithm;

import java.math.BigDecimal;

public class NoCommonArea {
    public static void main(String[] args) {
        System.out.println(1f == 0.9999999f);//false
        System.out.println(1f == 0.99999999f);//true   计算机按照16进制处理 1和0。999999999通过转为16进制 是一样的
        System.out.println("--------------");
        float f = 1.1f;
        double d = (double) f;
        System.out.println(f);  // 打印：1.1
        System.out.println(d);//1.100000023841858
        System.out.println(0.2 + .7); //0.8999999999999999


        System.out.println("--------------");

        BigDecimal num3 = new BigDecimal(Double.toString(0.1f));
        BigDecimal num4 = new BigDecimal(Double.toString(0.99999999f));
        System.out.println(num3 == num4);  // 打印 false

        BigDecimal num1 = new BigDecimal(Double.toString(0.2));
        BigDecimal num2 = new BigDecimal(Double.toString(0.7));

// 加
        System.out.println(num1.add(num2));  // 打印：0.9

// 减
        System.out.println(num2.subtract(num1));  // 打印：0.5

// 乘
        System.out.println(num1.multiply(num2));  // 打印：0.14

// 除
        System.out.println(num2.divide(num1));  // 打印：3.5

        System.out.println("---------------");
        String s1=null;
        String s2="";
        System.out.println(s2.equals(null));
    }
}
