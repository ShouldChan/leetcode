package JiebiDynamicProgramming;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/3
 * @description 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RecCover {
    /**
     * 时间复杂度O（n）
     * 空间复杂度O（1）
     * @param n
     * @return
     */
    public int recCover(int n){
        if(n==0||n==1||n==2)
            return n;
        else
            return recCover(n-1)+recCover(n-2);
    }

    public static void main(String[] args) {
        RecCover rc=new RecCover();
        System.out.println(rc.recCover(4));
    }
}
