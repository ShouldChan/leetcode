package JiebiMath;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/9/16
 * @description 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN_Solution {
    /**
     * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
     *
     * @param n
     * @return
     */
    public int bestFunction(int n) {
        int digit = 1, high = n / 10, low = 0, cur = n % 10;
        int res = 0;
        while (high != 0 || cur != 0) {//逆否 当high和cur同时为0的时候，越过最高位了。
            if (cur == 0)
                res += high * digit;
            else if (cur == 1)
                res += high * digit + low + 1;
            else
                res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    /**
     * 对10取模 然后判断个位是不是1 然后累加得出1的出现总数 复杂度O（nlog n）
     *
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = i;
            while (tmp != 0) {
                if (tmp % 10 == 1)
                    count++;
                tmp = tmp / 10;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution n = new NumberOf1Between1AndN_Solution();
        System.out.println(n.NumberOf1Between1AndN_Solution(12));
        System.out.println(n.bestFunction(12));
    }
}
