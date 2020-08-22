package JiebiMath;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/4
 * @description 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    /**
     * 负数用补码表示
     * 正数的补码=原码
     * 负数的补码=数字的反码+1
     * 时间复杂度O（32）
     * 空间负载度O（1）
     *
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((n & flag) != 0)
                count++;
            flag <<= 1; //左移
        }
        return count;
    }

    /**
     * 现考虑二进制数：val :1101000, val-1: 1100111 那么val & （val-1） : 1100000
     * 这种方法本质上的特性是利用二进制的特性，二进制数字-1的话，从右往左的第一个1就会改变，那一些位数值都会发生变化，
     * 这样将原值和-1值进行&操作，&的特性是有0为0，所以这样就可以把从右往左的第一个1消掉，每次操作就是计数统计了一个1，
     * 接下来就可以继续处理下一个1
     * 时间复杂度：O(n) n为val中1的个数
     * 空间复杂度：O(1)
     *
     * @param
     */
    public int bestFunc(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1 n1 = new NumberOf1();
        //-6 buma 1111 1010
        //6 yuanma 00000110
        System.out.println(n1.numberOf1(6));
        System.out.println(n1.bestFunc(6));
    }


}
