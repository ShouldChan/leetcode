package swordoffer;

public class Fibonacci {
    public int recur_Fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        return recur_Fibonacci(n - 1) + recur_Fibonacci(n - 2);


    }

    public int dp_Fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        Fibonacci fb = new Fibonacci();
        int result = fb.recur_Fibonacci(n);
        System.out.println(result);
        System.out.println(fb.dp_Fibonacci(n));
    }
}