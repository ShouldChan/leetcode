package JiebiArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/20
 * @description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrixClockwise {
    /**
     * time O(n)
     * space O(n)
     *
     * @param matrix
     * @return
     */
    public List<Integer> printMatrix(int[][] matrix) {
        int start = 0;
        List<Integer> result = new ArrayList<>();
        while (2 * start < matrix.length && 2 * start < matrix[0].length) {
            printClockwise(matrix, start, result);
            start++;
        }
        return result;
    }

    public void printClockwise(int[][] matrix, int start, List<Integer> result) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        int number = 0;
        //left -> right
        for (int i = start; i <= endX; i++) {
            number = matrix[start][i];
            result.add(number);
        }

        //up -> down
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                number = matrix[i][endX];
                result.add(number);
            }
        }
        //right->left
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                number = matrix[endY][i];
                result.add(number);
            }
        }
        //down -> up
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                number = matrix[i][start];
                result.add(number);
            }
        }
    }

    public static void main(String[] args) {
        PrintMatrixClockwise pm = new PrintMatrixClockwise();
//        int[][] matrix = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        int[][] matrix={{1},{2},{3},{4},{5}};
        List<Integer> result = pm.printMatrix(matrix);

//        System.out.println(result.size());
        for (Integer i : result) {
            System.out.print(i + "\t");
        }
    }
}
