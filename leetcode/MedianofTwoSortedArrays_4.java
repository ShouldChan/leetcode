package com.cxj.leetcode;

public class MedianofTwoSortedArrays_4 {
    public double findMedian(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
            int[] tempArr = A;
            A = B;
            B = tempArr;
        }
        int iMin = 0;
        int iMax = m;
        int halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin++;
            } else if (i > iMin && B[j] < A[i - 1]) {
                iMax--;
            } else {
                int maxLeft = 0;
                if (i == 0)
                    maxLeft = B[j - 1];
                else if (j == 0)
                    maxLeft = A[i - 1];
                else
                    maxLeft = Math.max(B[j - 1], A[i - 1]);
                if ((m + n) % 2 == 1)
                    return maxLeft;

                int minRight = 0;
                if (i == m)
                    minRight = B[j];
                else if (j == n)
                    minRight = A[i];
                else
                    minRight = Math.min(B[j], A[i]);

                return (maxLeft + minRight) / 2.0;

            }
        }
        return 0.0;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MedianofTwoSortedArrays_4 median = new MedianofTwoSortedArrays_4();
        int[] A = { 4 };
        int[] B = { 1, 2, 3, 5 };
        double result = median.findMedian(A, B);
        System.out.println(result);
    }
}