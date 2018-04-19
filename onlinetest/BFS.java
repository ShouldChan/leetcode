package com.cxj.onlinetest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static List<Integer> BFS(int[][] array, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            result.add(temp);
            for (int i = temp; i < array.length; i++) {
                if (array[temp][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    queue.offer(i);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
//        无向图的邻接矩阵
        int[][] array =
                {{0, 1, 1, 0, 0, 0, 0, 0},
                        {1, 0, 0, 1, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1, 1, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0}};
        boolean[] visited = new boolean[8];
        List<Integer> result = BFS(array, visited);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}