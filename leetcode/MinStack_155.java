package com.cxj.leetcode;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 思路：
 * 使用两个栈，一个保存数据，一个保存创建栈过程中所有最小值。
 * 具体过程：
 * 每次push的时候跟minStack栈顶比较，如果比它更小，则入minStack栈，所以栈顶一定是当前最小元素。
 * 每次pop的时候跟minStack栈顶比较，如果pop的不是栈顶元素，则pop的不是最小元素，minStack不必更新，反之要更新。
 */
public class MinStack_155 {
    /**
     * initialize your data structure here.
     */
    Stack val = new Stack();
    Stack minVal = new Stack();

    public MinStack_155() {

    }

    public void push(int x) {
        val.push(x);
        if (minVal.isEmpty()) {
            minVal.push(x);
        } else {
            if ((int) minVal.peek() >= x) {
                minVal.push(x);
            }
        }
    }

    public void pop() {
        int tmp = (int) val.pop();
        if (tmp == (int) minVal.peek()) {
            minVal.pop();
        }
    }

    public int top() {
        return (int) val.peek();
    }

    public int getMin() {
        return (int) minVal.peek();
    }

    public static void main(String[] args) {
        MinStack_155 minStack = new MinStack_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
