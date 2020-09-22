package JiebiArray;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/9/22
 * @description 最大连续1的个数
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int val : nums) {
            if (val == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes fm = new FindMaxConsecutiveOnes();
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(fm.findMaxConsecutiveOnes(nums));
    }
}
