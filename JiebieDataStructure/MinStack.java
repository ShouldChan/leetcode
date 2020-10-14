package JiebieDataStructure;

import java.util.Stack;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/16
 * @description 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MinStack {
    private Stack<Integer> normal = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        normal.push(node);
        if (min.isEmpty()) {
            min.push(node);
        } else {
            min.push(node <= min.peek() ? node : min.peek());
        }
    }

    public void pop() {
        normal.pop();
        min.pop();
    }

//    public int top() {
//        return normal.peek();
//    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        int[] array = {4, 2, 3, 6, 1};

        for (int i = 0; i < array.length; i++) {
            ms.push(array[i]);
        }
        System.out.println(ms.min());
    }
}
