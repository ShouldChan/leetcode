package JiebieDataStructure;

import java.util.Stack;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/19
 * @description 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
    /**
     * 时间复杂度O（n）
     * 空间复杂度O（n）
     * 顺序遍历两个数组，将入栈顺序依次压入临时栈，直到遇到和出栈顺序一样的就将两个元素弹出
     * @param pushA
     * @param popA
     * @return
     */
    public boolean isPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        if (pushA.length == 0)
            return false;
        for (int i = 0, j = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsPopOrder ipo = new IsPopOrder();
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 1, 2};
        System.out.println(ipo.isPopOrder(pushA, popA));
    }
}
