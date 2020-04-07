package DynamicProgramming.GreedyAlgorithm;

/**
 * date: 2020-04-07
 * 有 m 个糖果和 n 个孩子。我们现在要把糖果分给这些孩子吃，但是糖果少，孩子多（m < n），
 * 所以糖果只能分配给一部分孩子。每个糖果的大小不等，这 m 个糖果的大小分别是s1，s2，s3，……，sm。
 * 除此之外，每个孩子对糖果大小的需求也是不一样的，只有糖果的大小大于等于孩子的对糖果大小的需求的时候，
 * 孩子才得到满足。假设这 n 个孩子对糖果大小的需求分别是 g1，g2，g3，……，gn。
 * 那么如何分配糖果，能尽可能满足最多数量的孩子呢?
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求解：这道题如果用贪心来解解题思路还是比较明显的，对于每个小孩的需求 gn，
 * 只要给他所有大小大于 gn 的糖果中的最小值即可，这样就能把更大的糖果让给需求更大的小孩。
 */
public class CandyAndChildren {
    private static int dispatchCandy(int[] gList, int[] sList) {
        Arrays.sort(gList);
        System.out.println(gList);
        Arrays.sort(sList);
        System.out.println(sList);
        int maxResultNum = 0;
        for (int i = 0; i < gList.length; i++) {
            for (int j = 0; j < sList.length; j++) {
                if (gList[i] <= sList[j]) {
                    //满足条件了 说明这个小朋友拿到符合自己需求的糖果了
                    maxResultNum++;
                    System.out.println(maxResultNum);
                    //这个小朋友拿走了这个糖果 把这个糖果标为-1
                    sList[j] = -1;
                    break;
                }
            }
        }
        return maxResultNum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] gList = new int[N];
        for (int i = 0; i < N; i++) {
            gList[i] = in.nextInt();
        }
        int M = in.nextInt();
        int[] sList = new int[M];
        for (int j = 0; j < M; j++) {
            sList[j] = in.nextInt();
        }
        int result = dispatchCandy(gList, sList);
        System.out.println(result);
    }
    /**
     * 4
     * 1 4 2 6
     * 4
     * 1 2 3 7
     * 3
     */

}
