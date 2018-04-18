package com.cxj.onlinetest;

import java.util.Scanner;

/**
 * 题目描述
 * 爬山
 * 从空中俯瞰某山，可以看还曾一个n×m的矩阵，我们把行从上网下按1到n编号，
 * 把列从左往右按1到m编号，那么（i，j）就表示矩阵第i行第j列的位置，
 * 我们用h_ij表示（i，j）的海拔高度
 * <p>
 * 初始时，某人在(sx,sy)这个位置，他想往高走，每一次都可以选择向上、下、左、右
 * 其中一个方向走，单不能走出这个矩阵;同时他不愿意走到比他当前所在位置海拔要低的位置，
 * 也就是说在移动的过程中，每一步他斗志能向海拔不低于她当前所在位置的那些位置移动。
 * 请计算他能走到的最高高度。
 * <p>
 * 输入：
 * 第一行包含两个整数n,m表示矩阵的规模1<=n,m<=200
 * 第二行包含两个整数sx,sy表示初始时某人的位置1<=sx<=n,1<=sy<=m
 * 接下来n行每行包含m个数字，0<=h_ij<=10^9,表示位置（i，j）的海拔高度。
 * 输出：
 * 输出该人能够移动到的最高高度
 * <p>
 * 样例输入：
 * 2 2
 * 1 1
 * 2 1
 * 1 3
 * 样例输出：
 * 2
 * <p>
 * Hint
 * input sample2
 * 23
 * 11
 * 152
 * 049
 * output sample2
 * 5
 */
public class Baidu_2 {

    public static void DFS(int iIndex, int jIndex, int pre, boolean[][] visited, int[][] nums, int[] res) {
        if (iIndex > (nums.length - 1) || iIndex < 0 || jIndex > (nums[0].length - 1) ||
                jIndex < 0 || visited[iIndex][jIndex] || nums[iIndex][jIndex] < pre) {
            res[0] = Math.max(res[0], pre);
            return;
        }
        visited[iIndex][jIndex] = true;
        DFS(iIndex + 1, jIndex, nums[iIndex][jIndex], visited, nums, res);
        DFS(iIndex - 1, jIndex, nums[iIndex][jIndex], visited, nums, res);
        DFS(iIndex, jIndex + 1, nums[iIndex][jIndex], visited, nums, res);
        DFS(iIndex, jIndex - 1, nums[iIndex][jIndex], visited, nums, res);
        visited[iIndex][jIndex] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sx = sc.nextInt() - 1;
        int sy = sc.nextInt() - 1;

        if (n < 1 || m > 200 || sx < 0 || sx > n - 1 || sy < 0 || sy > m - 1)
            return;
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }

        int[] res = new int[1];
        boolean[][] visited = new boolean[n][m];
        DFS(sx, sy, Integer.MIN_VALUE, visited, nums, res);
        System.out.println(res[0]);
    }

}