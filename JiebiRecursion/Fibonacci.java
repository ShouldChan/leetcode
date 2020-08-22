package JiebiRecursion;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/2
 * @description 斐波那契数列
 */
public class Fibonacci {
    /**
     * 使用递归来做，时间复杂度为O（n）
     * @param n
     * @return
     */
    public int func(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return func(n - 1) + func(n - 2);
        }
    }

    /**
     * 使用dp思想来做 时间复杂度为O（n） 空间复杂度为O（n）
     * @param n
     * @return
     */
    public int dp(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci();
        System.out.println(fb.func(5));
        System.out.println(fb.dp(5));
    }
}
