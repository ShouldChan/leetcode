package com.cxj.onlinetest;

import java.util.*;

/**
 *
 */
public class Toutiao_1 {
    public static Set<Integer> findAllT(ArrayList<Integer> array) {
        Set<Integer> set = new HashSet<>();
        //最小差值
//        int min=Math.abs(array.get(array.size()-1)-array.get(0));
        for (int i = 0; i < array.size(); i++) {
            for (int j = i + 1; j < array.size(); j++) {
                int temp = Math.abs(array.get(i) - array.get(j));
                set.add(temp);
            }
        }
        return set;
    }

    public static boolean isValid(ArrayList<Integer> array, int mint) {
        //验证数列是否合法
        for (int i = 0; i < array.size(); i++) {
//            if (array.get(i) + mint > array.get(array.size() - 2) || array.get(i) - mint < array.get(1))
//                return false;
            for (int j = i + 1; j < array.size(); j++) {
                int temp = array.get(j) - array.get(i);
                if (temp % mint != 0)
                    return false;
            }
        }
        return true;
    }

    public static int findZhouqi(ArrayList<Integer> array) {
        Set<Integer> set = new HashSet<>();
        set = findAllT(array);
        Iterator<Integer> it = set.iterator();

        int min_t = array.get(array.size() - 1) - array.get(0);
        while (it.hasNext()) {
            int t = it.next();

            if (isValid(array, t)) {
                if (t <= min_t)
                    min_t = t;
            }
        }
        return min_t;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 0 || n >= 10)
            return;
        int x;
        ArrayList<Integer> array = new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int nn = sc.nextInt();
            for (int j = 0; j < nn; j++) {
                x = sc.nextInt();
                array.add(x);
            }
            //对某个数列操作
            int t = findZhouqi(array);
//            System.out.println(t);
            result.add(t);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}