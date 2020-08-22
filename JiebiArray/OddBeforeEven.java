package JiebiArray;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/18
 * @description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class OddBeforeEven {
    /**
     * 时间复杂度O（n^2）
     * 空间复杂度O（1）
     * @param array
     */
    public void reOrderArray(int [] array) {
        //记录下一个奇数的位置要放的位置
        int i=0;
        for (int j=0;j<array.length;j++){
            int tmp=array[j];
            if((tmp%2)!=0){//是奇数
                for(int k=j-1;k>=i;k--){
                    array[k+1]=array[k];//把奇数往迁移
                }
                array[i++]=tmp;//奇数放到i的位置，i后移
            }
        }
    }

    public static void print(int[] array){
        for(int value:array){
            System.out.print(value+"\t");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        if((1%2)!=0)
            System.out.println("odd");
        else
            System.out.println("even");
        int[] array={1,2,3,4,5,6};
        OddBeforeEven obe=new OddBeforeEven();
        obe.reOrderArray(array);
        print(array);
    }
}
