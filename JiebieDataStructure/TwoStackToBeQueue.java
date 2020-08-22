package JiebieDataStructure;

import java.util.Stack;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/1
 * @description 两个栈实现队列
 */
public class TwoStackToBeQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 把要放进队列的元素 都先放在stack1中，stack1的作用就是负责进队列
     *
     * @param x
     */
    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        //保持stack2是空的，stack2这边有一个元素就出掉一个 这样就是先进先出了
        while (!stack2.isEmpty()) {
            return stack2.pop();
        }
        //stack2为空了 就执行以下代码，就把stack1中的元素放进stack2中，然后stack2在出元素
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStackToBeQueue ts = new TwoStackToBeQueue();
        ts.push(1);
        ts.push(2);
        ts.push(3);
        int count = 3;
        while (count-- != 0) {
//            System.out.println(count);
            System.out.println(ts.pop());
        }
        }
    }
