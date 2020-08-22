package swordoffer;

/**
 * 变态青蛙条台阶
 * 问题描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路：when n=0, f(n)=0; when n=1, f(n)=1; when n>=2, f(n)=2*f(n-1)=2^(n-1)
 */
public class TerribleFragJump {
    public int JumpFloorII(int target) {
        if (target <= 0)
            return 0;
        else if (target == 1)
            return 1;
        else if (target >= 2)
            return 2 * JumpFloorII(target - 1);
        return 0;
    }
    //使用位运算 速度更快
    public int terrible(int n){
        if(n==0)
            return 0;
        return 1<<--n;
    }

    public static void main(String[] args) {
        TerribleFragJump fj = new TerribleFragJump();
        System.out.println(fj.JumpFloorII(10));
        System.out.println(fj.terrible(10));
    }
}