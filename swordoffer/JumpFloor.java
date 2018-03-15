package com.cxj.swordoffer;

public class JumpFloor {
    public int iter_jump(int target) {
        int first = 1;
        int second = 2;
        int result = 0;
        if (target == 1 || target == 2) {
            return target;
        } else {
            for (int i = 3; i <= target ; i++) {
                result = first + second;
                first = second;
                second = result;
            }
            return result;
        }

    }

    public int recur_jump(int target) {
        if (target == 1 || target == 2) {
            return target;
        } else {
            return recur_jump(target - 1) + recur_jump(target - 2);
        }
    }

    public static void main(String[] args) {
        int target = 10;
        JumpFloor jf = new JumpFloor();
        int iter_result = jf.iter_jump(target);
        int recur_result = jf.recur_jump(target);
        System.out.println("iter:" + iter_result);
        System.out.println("recur:" + recur_result);
    }
}