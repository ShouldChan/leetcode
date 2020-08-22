package JiebieDataStructure;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/1
 * @description 两个队列实现栈
 */
public class TwoQueueToBeStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    /**
     * 进栈功能保持一个队列为空 一个队列不为空，不为空那个队列是要用来做出栈功能的时候暂存那些先进栈的元素
     *
     * @param x
     */
    public void push(int x) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.offer(x);
        }
        if (queue1.isEmpty()) {
            queue2.offer(x);
        }
        if (queue2.isEmpty()) {
            queue1.offer(x);
        }
    }

    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            System.out.println("Stack is empty");
        }
        //因为之前的入栈操作会保持一个队列为空的
        if (queue1.isEmpty()) {
            //只留一个元素，用来实现先进后出
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
        return (Integer) null;
    }

    public static void main(String[] args) {
        TwoQueueToBeStack tq = new TwoQueueToBeStack();
        tq.push(1);
        tq.push(2);
        tq.push(3);
        int count = 3;
        while (count-- != 0) {
            System.out.println(tq.pop());
        }
    }
}
