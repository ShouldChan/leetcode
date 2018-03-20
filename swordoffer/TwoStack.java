package com.cxj.swordoffer;

import java.util.Stack;

public class TwoStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack2.empty()) {
            return stack2.pop();
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStack ts = new TwoStack();
        ts.push(1);
        ts.push(2);
        ts.push(3);
        System.out.println(ts.pop());
        System.out.println(ts.pop());
        System.out.println(ts.pop());
    }
}