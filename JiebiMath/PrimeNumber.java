package JiebiMath;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/22
 * @description 素数（质数）
 */
public class PrimeNumber {
    /**
     * 一个数看能不能被（2，根号这个数）的范围里面的数整除，如果可以，不是素数
     * @param number
     * @return
     */
    public boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> primeInN(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PrimeNumber pn = new PrimeNumber();
        ArrayList<Integer> result = pn.primeInN(100);
        for (Integer i : result) {
            System.out.print(i + "\t");
        }
    }
}
