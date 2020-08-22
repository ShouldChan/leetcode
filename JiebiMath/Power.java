package JiebiMath;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/5
 * @description 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。  保证base和exponent不同时为0
 */
public class Power {
    /**
     * 递归的方法 分为奇数和偶数的做法
     * 时间复杂度O（logn）
     * 空间复杂度O（logn）递归栈 要记住logn个变量
     *
     * @param base
     * @param exponent
     * @return
     */
    public double func(double base, int exponent) {
        if (exponent == 0)
            return 1.0;
        double recBody = func(base, exponent / 2);
        if (exponent % 2 == 1) {
            return recBody * recBody * base;
        } else {
            return recBody * recBody;
        }
    }

    public double power(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        return func(base, exponent);
    }

    /**
     * 6 = 0*2^0 + 1*2^1 + 1*2^2
     * x^6 = x^(1*2^1) * x^(1*2^2)
     *
     * @param base
     * @param exponent
     * @return
     */
    public double greatPower(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double x = base;
        double cur = 1.0;
        while (exponent != 0) {
            if ((exponent & 1) != 0) {
                cur *= x;
            }
            x *= x;
            exponent >>= 1;
        }
        return cur;
    }

    public static void main(String[] args) {
        Power p = new Power();
        System.out.println(p.power(2, -4));
        System.out.println(p.greatPower(2, -4));
    }
}
