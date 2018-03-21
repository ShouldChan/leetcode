package com.cxj.swordoffer;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueue {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    public void push(int node) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(node);
        }
        if (queue1.isEmpty())
            queue2.add(node);
        if (queue2.isEmpty())
            queue1.add(node);
    }

    public int pop() {
//      保证每次两个队列 有一个为空，某个队列元素为1就出队列
        if (queue1.isEmpty() && queue2.isEmpty())
            throw new RuntimeException("Stack is empty");
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        return (Integer) null;
    }

    public static void main(String[] args) {
        TwoQueue tw = new TwoQueue();
        tw.push(1);
        tw.push(2);
        tw.push(3);
        System.out.println(tw.pop());
        System.out.println(tw.pop());
        System.out.println(tw.pop());
    }
}