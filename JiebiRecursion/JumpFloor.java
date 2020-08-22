package JiebiRecursion;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/2
 * @description 青蛙跳台阶
 */
public class JumpFloor {
    public int recur_jump(int target) {
        if (target == 1 || target == 2) {
            return target;
        } else {
            return recur_jump(target - 1) + recur_jump(target - 2);
        }
    }

    public static void main(String[] args) {
        JumpFloor jf=new JumpFloor();
        System.out.println(jf.recur_jump(5));
    }
}
