package com.cxj.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CountPrimes_204 {
    public int countPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true)
                list.add(i);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return list.size();
    }

    public static void main(String[] args) {
        CountPrimes_204 cp = new CountPrimes_204();
        System.out.println(cp.countPrimes(10));
    }
}