package JiebiDynamicProgramming.GreedyAlgorithm;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/3
 * @description 疯狂青蛙跳台阶，n阶的一次可以跳1层 2层 n层,求n阶的有多少种跳法
 */
public class CrazyJumpFloor {
    /**
     * f(n)表示n阶里有一次跳n阶的跳法数
     * 重点是推导：
     * 理解1：
         * f(n)=f(n-1)+f(n-2)+...+f(n-(n-1))+f(n-n)
         * =f(n-1)+f(n-2)+...+f(1)+f(0)           (1)
         * f(n-1)=f(n-2)+f(n-3)+...+f(1)+f(0)         (2)
         * (1)-(2):
         * f(n)=f(n-1)*2
     * 理解2：
         * 换个角度抽象理解
         * n阶有n块板构成，要到达第n块板，第n-1块有两种可能，一是被跳到了，二是没被跳到，所以得出
         * f(n)=2*f(n-1)
     *
     * @param n
     * @return
     */
    public int func(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return 2 * func(n - 1);
        }
    }

    public static void main(String[] args) {
        CrazyJumpFloor cjf = new CrazyJumpFloor();
        System.out.println(cjf.func(5));
    }
}
