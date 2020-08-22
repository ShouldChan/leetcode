package JiebiArray;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/1
 * @description 旋转数组的最小数字 把一个数组最开始的若干个元素半岛数组的末尾叫做数组的旋转，
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
 * 该数组的最小值为1。NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class TheSmallestNumInRotateArray {
    public int findTheSmallest(int[] array) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            //二分法缩小范围
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                //若出现1，0，1，1，1这种情况 就无法直接判断最小数字在mid左边还是右边 就缩小high的值 这样缩小范围来找
                //如果没有这种重复情况，就直接return就完事儿了
                high--;
                System.out.println(high);
            }
        }
        return array[high];
    }

    public static void main(String[] args) {
        TheSmallestNumInRotateArray ob = new TheSmallestNumInRotateArray();
        int[] array = {3,4,5,1,1,1,2,2,2,3};
        System.out.println(ob.findTheSmallest(array));
    }
}
