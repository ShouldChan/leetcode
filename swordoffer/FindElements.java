package com.cxj.swordoffer;

public class FindElements {
    public boolean Find(int target, int[][] array) {
//        boolean found=false;
        int rows = array.length;
        int columns = array[0].length;
        if (rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0) {
                if (array[row][column] == target) {
                    return true;
                } else if (array[row][column] > target) {
                    --column;
                } else {
                    ++row;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindElements fe = new FindElements();
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target = 3;
        boolean found = fe.Find(target, array);
        System.out.println(found);

    }
}