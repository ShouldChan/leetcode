package com.cxj.onlinetest;

/**
 * 给你一个无序数组，求其排成有序的最少操作数
 * 一个无序数列，假定一次操作可以将其中某个数移到另一个位置上至少需要几次操作能使序列变的单调非递减有序？
 * 画重点：操作数
 * <p>
 * 如果一个序列全部是递减 要改成递增 最少要n-1次操作
 * <p>
 * 转换为最长非连续递增子序列的长度
 * 依次对每个序列求最长非递减子序列，用dp[i]记录1-i个元素中最长子序列的长度
 * 得到递推公式为：
 * dp[i]=max(dp[i],dp[j]+1)   array[j]<=array[i]且j<i
 */
public class Baidu_Inter_1_2 {

    public static int longestSubLen(int[] array) {
        int count = 0;
        int len = array.length;

//        dp[i]保存 array[1  i]的最长子序列的长度
        int[] dp = new int[len];
        int subLen = 0;

        for (int i = 0; i < len; i++) {

            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] <= array[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            subLen = Math.max(subLen, dp[i]);
        }
        count = len - subLen;
        return count;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = sc.nextInt();
//        }
        int[] array = {5, 1, 2, 3, 4, 3, 5};
        System.out.println(longestSubLen(array));

    }
}