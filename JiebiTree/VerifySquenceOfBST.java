package JiebiTree;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/27
 * @description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return isPost(sequence, 0, sequence.length - 1);
    }

    public boolean isPost(int[] nums, int low, int high) {
        if (low >= high) return true;
        int mid = high;
        for (int i = low; i < high; i++) {
            if (nums[i] > nums[high]) {
                mid = i;
                break;
            }
        }
        for (int i = mid; i < high; i++) {
            if (nums[i] <= nums[high]) return false;
        }
        return isPost(nums, low, mid - 1) && isPost(nums, mid, high - 1);
    }

}
