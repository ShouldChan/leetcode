package JiebiArray;

import java.util.Scanner;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/5/18
 * @description 二维数组查找
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class FindIn2DArray {
    public boolean findInt(int[][] matrix, int rows, int columns, int number) {
        boolean foundRlt = false;
        if (matrix != null && rows > 0 && columns > 0) {
            // 左上角开始
            int i = 0;
            // 右上角的数字
            int j = columns - 1;
            while (i < rows && j >= 0) {
                if (matrix[i][j] == number) {
                    foundRlt = true;
                    break;
                } else if (matrix[i][j] > number) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return foundRlt;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("input the row number of matrix:\t");
        int N_ROWS = input.nextInt();
        System.out.println("input the col number of matrix:\t");
        int N_COLS = input.nextInt();
        int[][] matrix = new int[N_ROWS][N_COLS];
        System.out.println("input the matrix by rows:\t");
        for (int i = 0; i < N_ROWS; i++) {
            for (int j = 0; j < N_COLS; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        FindIn2DArray findObj = new FindIn2DArray();
        System.out.println("input the number we need to find:\t");
        int number = input.nextInt();
//        int[][] matrix = {{1, 2, 8, 9,10}, {2, 4, 9, 12,13}, {4, 7, 10, 13,14,}, {6, 8, 11, 15,19}};
//        int N_ROWS=matrix.length;
//        int N_COLS=matrix[0].length;
//        int number=5;
        boolean result = findObj.findInt(matrix, N_ROWS, N_COLS, number);
        System.out.println(result);
    }
}
